
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
                    <a href='<c:url value="/admin/home" />'>Home</a>
                </li>
                <li class="active">Chi tiết tòa nhà</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <form:form modelAttribute="modelBuildingEdit" cssClass="form-horizontal" id="formEdit" method="get">

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
                                    <option selected disabled>Chọn Quận</option>
                                    <c:forEach items="${districts}" var="item">
                                        <option ${item.selected} value="${item.code}">${item.name}</option>
                                        <%--<option ${item.selected} value="${item.code}">${item.name}</option>--%>
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
                                <form:input path="rentArea" cssClass="form-control"/>
                            </div>
                        </div>


                          <%--<div class="form-group">
                              <label class="col-sm-3 control-label no-padding-right"> Mô tả diện tích </label>
                              <div class="col-sm-9">
                                  <form:input path="rent" cssClass="form-control"/>
                              </div>
                          </div>--%>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> Gía thuê </label>
                            <div class="col-sm-9">
                                <input type="number" class="form-control" name="rentPrice"
                                       value="${modelBuildingEdit.rentPrice}" />
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
                                <form:input path="serviceFee" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> Phí ngoài giờ </label>
                            <div class="col-sm-9">
                                <form:input path="overtimeFee" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> Tiền điện </label>
                            <div class="col-sm-9">

                                <input type="number" class="form-control" name="electricityFee"
                                       value="${modelBuildingEdit.electricityFee}" />
                            </div>
                        </div>

                        <%--<div class="form-group">--%>
                            <%--<label class="col-sm-3 control-label no-padding-right"> Phí dịch vụ </label>--%>
                            <%--<div class="col-sm-9">--%>
                                <%--<form:input path="serviceFee" cssClass="form-control"/>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> Loại tòa nhà </label>
                            <div class="col-sm-9">
                                <c:forEach items="${buildingTypes}" var="item">
                                    <input class="form-check-input" type="checkbox" name="types"
                                           ${item.checked}  value="${item.code}" />
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
                            <label class="col-sm-3 control-label no-padding-right"> Tên quản lí </label>
                            <div class="col-sm-9">
                                <form:input path="managerName" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> Số điện thoại quản lý </label>
                            <div class="col-sm-9">
                                <input type="number" class="form-control" name="managerPhone"
                                       value="${modelBuildingEdit.managerPhone}" />
                            </div>
                        </div>

                        <%--update image--%>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Hình đại diện</label>
                            <input class="col-sm-3 no-padding-right" type="file" value="${modelBuildingEdit.image}" id="uploadImage"/>
                            <div class="col-sm-9">
                                <c:if test="${not empty modelBuildingEdit.image}">
                                    <c:set var="imagePath" value="/repository${modelBuildingEdit.image}"/>
                                    <img src="${imagePath}" id="viewImage" width="200px" height="200px" style="margin-top: 50px">
                                </c:if>
                                <c:if test="${empty modelBuildingEdit.image}">
                                    <img src="/img/default_img.jpg" id="viewImage" width="200px" height="200px">
                                </c:if>
                            </div>
                        </div>

                       <%-- <div class="form-group">
                            <div class="col-xs-9 col-xs-push-3">
                                <input type="button" class="btn btn-md btn-primary"
                                       value="${valueBtn}" id="submitBtn"/>
                                <input type="button" class="btn btn-md btn-warning"
                                       value="Huỷ" id="cancelBtn"/>
                                <img src="/img/loading.gif" style="display: none; height: 100px" id="loading_image">
                            </div>
                        </div>--%>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"></label>
                            <div class="col-sm-9 text-center">
                                <c:if test="${modelBuildingEdit.id == null}" >
                                    <button type="button" class="btn btn-primary" id="btnEditBuilding">Thêm Tòa Nhà</button>
                                </c:if>

                                <c:if test="${modelBuildingEdit.id != null}" >
                                    <button type="button" class="btn btn-primary" id="btnEditBuilding">Update Tòa Nhà</button>
                                </c:if>
                                <button type="button" id="close" class="btn btn-primary">Huỷ</button>
                                <img src="/img/loading.gif" style="display: none; height: 100px" id="loading_image">
                            </div>
                        </div>
                    </form:form>
                </div>
            </div><!-- /.row -->
        </div> <!--page-content -->
    </div>
</div><!-- /.main-content -->

<script>

     var imageBase64 = '';
     var imageName = '';

    $('#btnEditBuilding').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formEdit').serializeArray();
        var id = ${modelBuildingEdit.id} + '';
        if(id != '') {
            data["id"] = id;
        }
        var types = [];

        formData.forEach(function(item, e) {
            if (item.name == "types") {
                types.push(item.value);
            } else if (item.name != "types") {
                data[item.name] = item.value;
            }
            // image
            if ('' !== e.value && null != e.value) {
                data['' + e.name + ''] = e.value;
            }
            if ('' !== imageBase64) {
                data['imageBase64'] = imageBase64;
                data['imageName'] = imageName;
            }
        });

        var buildingId = data['id'];
        data["types"] = types;
        $('#loading_image').show();

        $.ajax({
            type: "PUT",
            url: '<c:url value="/api/building"/>',
            data: JSON.stringify(data),
            dataType: "json",               // kiểu dữ liệu server gửi cho client
            contentType: "application/json",//kieu du lieu tu client gui ve server
            success: function (response) {
                $('#loading_image').hide();
                window.location.href = '<c:url value="/admin/building-list" />'
            },
            error: function (response) {
                $('#loading_image').hide();
                alert("error : fail")
                console.log(response)
            }
        });
    })

    $("#close").click(function(){
        window.location.href = '<c:url value="/admin/building-list" />' // thay đổi URL sang trang bạn muốn chuyển đến
        window.close(); // đóng trang hiện tại
    });


    $('#uploadImage').change(function (event) {
        var reader = new FileReader();
        var file = $(this)[0].files[0];
        reader.onload = function(e){
            imageBase64 = e.target.result;
            imageName = file.name; // ten hinh khong dau, khoang cach. vd: a-b-c
        };
        reader.readAsDataURL(file);
        openImage(this, "viewImage");
    });

    function openImage(input, imageView) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#' +imageView).attr('src', reader.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
</script>
</body>
</html>
