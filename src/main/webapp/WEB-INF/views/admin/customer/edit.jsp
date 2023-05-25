
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="customerEditURL" value="/admin/customer-edit"/>
<c:url var="formUrl" value="/api/customer"/>
<html>
<head>
    <title>Chỉnh sửa người dùng</title>
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
                            <label class="col-sm-2 control-label no-padding-right"> Tên đầy đủ </label>
                            <div class="col-sm-8">
                                <form:input path="fullName" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label no-padding-right"> Số điện thoại </label>
                            <div class="col-sm-8">
                                <form:input path="phone" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label no-padding-right"> Email </label>
                            <div class="col-sm-8">
                                <form:input path="email" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label no-padding-right"> Tên công ty </label>
                            <div class="col-sm-8">
                                <form:input path="company" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label no-padding-right"> Nhu cầu </label>
                            <div class="col-sm-8">
                                <form:input path="requirement" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label no-padding-right"> Ghi chú </label>
                            <div class="col-sm-8">
                                <form:input path="note" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-1 control-label no-padding-right"></label>
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
        </div> <!--page-content -->
    </div>
</div><!-- /.main-content -->

<script>

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
