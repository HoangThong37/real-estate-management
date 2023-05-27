<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="customerEditURL" value="/admin/customer-edit"/>
<c:url var="formUrl" value="/api/customer"/>
<c:url var="customerApiTrans" value="/api/customer/transaction" />

<html>
<head>
    <title>CHI TIẾT KHÁCH HÀNG</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href='<c:url value="/admin/home" />'>Home</a>
                </li>
                <li class="active">Thông tin khách hàng</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <form:form modelAttribute="customerEdit" action="${customerEditURL}" cssClass="form-horizontal" id="formEdit" method="get">

                        <div class="form-group">
                            <label class="col-sm-3"> Tên đầy đủ </label>
                            <div class="col-sm-9">
                                <form:input path="fullName" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3"> Số điện thoại </label>
                            <div class="col-sm-9">
                                <form:input path="phone" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3"> Email </label>
                            <div class="col-sm-9">
                                <form:input path="email" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3"> Tên công ty </label>
                            <div class="col-sm-9">
                                <form:input path="company" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3"> Nhu cầu </label>
                            <div class="col-sm-9">
                                <form:input path="requirement" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3"> Ghi chú </label>
                            <div class="col-sm-9">
                                <form:input path="note" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"></label>
                            <div class="col-sm-8 text-center">
                                <c:if test="${customerEdit.id == null}" >
                                    <button type="button" class="btn btn-success" id="btnEditCustomer">Thêm Khách hàng</button>
                                </c:if>

                                <c:if test="${customerEdit.id != null}" >
                                    <button type="button" class="btn btn-primary" id="btnEditCustomer">Cập nhật khách hàng</button>
                                </c:if>
                                <button type="button" id="close" class="btn btn-dark">Huỷ</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div><!-- /.row -->
            </br>
            <div class="row">
                <div class="col-md-12">
                    <c:forEach var="item" items="${transactionMap}">
                        <div class="row">
                            <div class="col-xs-12">
                                <c:if test="${not empty customerEdit.id}">
                                    <div class="col-md-2">
                                        <h4 style="color: darkred">${item.value}</h4>
                                    </div>
                                    <div class="col-md-10">
                                        <button class="btn btn-white btn-info btn-bold"
                                                type="button"
                                                value="${item.key}"
                                                data-toggle="tooltip" title="Thêm Giao Dịch"
                                                onclick="btnAddTransaction(value)">
                                            <i class="fa fa-plus-circle" aria-hidden="true"></i>
                                        </button>
                                    </div>
                                </c:if>

                                <c:if test="${empty customerEdit.id}">
                                    <h4 style="color: darkred">${item.value}</h4>
                                </c:if>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-xs-12">
                                <div>
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Ngày Tạo</th>
                                                <th>Ghi Chú</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="value" items="${findTransactionByCustomer}">
                                                <c:if test="${item.key == value.code}" >
                                                    <tr>
                                                        <td>${value.createdDate}</td>
                                                        <td>${value.note}</td>
                                                    </tr>
                                                </c:if>
                                            </c:forEach>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <td></td>
                                                <td><input type="text" id="note${item.key}"
                                                           class="form-control" name="${item.key}"></td>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div> <!--page-content -->
    </div>
</div><!-- /.main-content -->


<script>

    function btnAddTransaction(value) {
        var data = {
            "code" : value,
            "note" : $("#note" + value + "").val(),
            "customerId" : "${customerEdit.id}"
        };

        $.ajax({
            type: "POST",
            url: '${customerApiTrans}',
            data: JSON.stringify(data),
            dataType: "json",                // kiểu dữ liệu server gửi cho client
            contentType: "application/json", //kieu du lieu tu client gui ve server
            success: function (response) {
                window.location.reload()
            },
            error: function (response) {
                alert("error : fail")
                console.log(response)
            }
        });
    }

   $('#btnEditCustomer').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formEdit').serializeArray();
        var id = ${customerEdit.id} + '';
        if(id != '') {
            data["id"] = id;
        }
       $.each(formData, function (i, v) {
           data["" + v.name + ""] = v.value;
       });

       $.ajax({
            type: "POST",
            url: '${formUrl}',
            data: JSON.stringify(data),
            dataType: "json",               // kiểu dữ liệu server gửi cho client
            contentType: "application/json",//kieu du lieu tu client gui ve server
            success: function (response) {
                window.location.href = '<c:url value="/admin/customer-list" />'
            },
            error: function (response) {
                alert("error : fail")
                console.log(response)
            }
       });
    })

    $("#close").click(function(){
        window.location.href = '<c:url value="/admin/customer-list" />' // thay đổi URL sang trang bạn muốn chuyển đến
        window.close(); // đóng trang hiện tại
    });

</script>
</body>
</html>
