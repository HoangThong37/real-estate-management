
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="buildingEditURL" value="/api/building"/>
<html>
<head>
    <title>Chỉnh sửa tòa nhà</title>
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
                    <a href="#">Home</a>
                </li>
                <li class="active">Chi tiết tòa nhà</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <form:form commandName="modelBuildingEdit" cssClass="form-horizontal" id="formEdit" method="get">

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> Tên tòa nhà </label>
                            <div class="col-sm-9">
                                <form:input path="name" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Quận</label>
                            <div class="col-sm-2">
                                <select class="form-control" name="district">
                                    <option>Chọn quận</option>
                                    <c:forEach items="${districts}" var="item">
                                        <option ${item.selected} value="${item.code}">${item.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> Phường </label>
                            <div class="col-sm-9">
                                <form:input path="ward" cssClass="form-control"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> Đường </label>
                            <div class="col-sm-9">
                                <form:input path="street" cssClass="form-control"/>
                            </div>
                        </div>

                       <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> Kết cấu </label>
                            <div class="col-sm-9">
                                <form:input path="structure" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> Số tầng hầm </label>
                            <div class="col-sm-9">
                                <input type="number" class="form-control" name="numberOfBasement"
                                       value="${modelBuildingEdit.numberOfBasement}" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> Diện tích sàn </label>
                            <div class="col-sm-9">
                                <input type="number" class="form-control" name="floorArea"
                                       value="${modelBuildingEdit.floorArea}" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> Hướng </label>
                            <div class="col-sm-9">
                                <form:input path="direction" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> Hạng </label>
                            <div class="col-sm-9">
                                <form:input path="level" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                           <label class="col-sm-3 control-label no-padding-right"> Diện tích thuê </label>
                            <div class="col-sm-9">
                                <form:input path="areaRent" cssClass="form-control"/>
                            </div>
                        </div>


                        <%--  <div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right"> Mô tả diện tích </label>
                              <div class="col-sm-9">
                                  <form:input path="" cssClass="form-control"/>
                              </div>
                          </div>--%>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> Gía thuê </label>
                            <div class="col-sm-9">
                                <form:input path="rentPrice" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> Mô tả giá </label>
                            <div class="col-sm-9">
                                <form:input path="rentPriceDescription" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> Phí dịch vụ </label>
                            <div class="col-sm-9">
                                <form:input path="rentPrice" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> Phí ngoài giờ </label>
                            <div class="col-sm-9">
                                <form:input path="overtimeCost" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> Tiền điện </label>
                            <div class="col-sm-9">
                                <form:input path="electricityCost" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> Phí dịch vụ </label>
                            <div class="col-sm-9">
                                <form:input path="serviceCost" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> Loại tòa nhà </label>
                            <div class="col-sm-9">
                                <c:forEach items="${buildingTypes}" var="item">
                                    <input class="form-check-input" type="checkbox" name="type"
                                        ${item.checked} value="${item.code}">
                                    <label class="form-check-label" >
                                            ${item.name}
                                    </label>
                                </c:forEach>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> Ghi chú </label>
                            <div class="col-sm-9">
                                <form:input path="note" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-9 text-center">
                                <button type="button" class="btn btn-primary" id="btnAddBuilding" name="btnAddBuilding" >Add Building</button>
                                <button type="button" class="btn btn-primary" id="btnRemove" name="btnRemove"  >Update Building</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div><!-- /.row -->
        </div> <!--page-content -->
    </div>
</div><!-- /.main-content -->

<script>
    //btnAddBuilding
    $('#btnAddBuilding').click(function (e) {
        //  call api add building function
        // t1. cái pthuc đẩy về là : POST
        // t2. nhập đoạn url vô
        // t3. cái dữ liệu mình đẩy vô là chuỗi json - cần phải định nghĩa (chuỗi: text/plain / json: json)
        e.preventDefault();
        var data = {};
        //var buildingTypes = [];
        var formData = $('#formEdit').serializeArray;  // lấy data tự động

        /*$.each(formData, function (index, v) {
            if (v.name == 'buildingTypes') {
                buildingTypes.push(v.value);
            } else {
                data["" + v.name + ""] = v.value;
            }
        });
        data["buildingTypes"] = buildingTypes;*/

        $.each(formData, function (index, v) {
                data["" + v.name + ""] = v.value;
        });
        $.ajax({
            type: 'POST',
            url: "${buildingAPI}",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",

            success: function (response) {
                console.log('success');
            },
            error: function (response) {
                console.log('faild')
                console.log(response)
            }
        });
    });
</script>

</body>
</html>
