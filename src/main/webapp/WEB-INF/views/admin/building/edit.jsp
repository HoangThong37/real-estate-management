
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="buildingAPI" value="/api/building"/>
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
                <li class="active">Building Edit</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <form class="form-horizontal" role="form" id="formEdit">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="name"> Tên tòa nhà </label>
                            <div class="col-sm-9">
                                <input type="text" id="name" class="form-control" name="name" value="name"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="district">Quận hiện có</label>
                            <div class="col-sm-2">
                                <select class="form-control" name="district" id="district" aria-label="Default select example">
                                    <option selected>--Chọn quận--</option>
                                    <option value="1">One</option>
                                    <option value="2">Two</option>
                                    <option value="3">Three</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="ward"> Phường </label>
                            <div class="col-sm-9">
                                <input type="text" id="ward" class="form-control" name="ward" value="ward"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="street" > Đường </label>
                            <div class="col-sm-9">
                                <input type="text" id="street" class="form-control" name="street" value="street" />
                            </div>
                        </div>

                       <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="structure"> Kết cấu </label>
                            <div class="col-sm-9">
                                <input type="number" id="structure" class="form-control" name="street"  />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="numberofbasement"> Số tầng hầm </label>
                            <div class="col-sm-9">
                                <input type="text" id="numberofbasement" class="form-control" name="numberofbasement" value="numberofbasement"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="buildingarea"> Diện tích sàn </label>
                            <div class="col-sm-9">
                                <input type="text" id="buildingarea" class="form-control" name="buildingarea" value="buildingarea" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="direction"> Hướng </label>
                            <div class="col-sm-9">
                                <input type="text" id="direction" class="form-control" name="direction" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="level"> Hạng </label>
                            <div class="col-sm-9">
                                <input type="text" id="level" class="form-control" name="level" />
                            </div>
                        </div>

                        <div class="form-group">
                           <label class="col-sm-3 control-label no-padding-right" for="dientichthue"> Diện tích thuê </label>
                            <div class="col-sm-9">
                                <input type="number" id="dientichthue" class="form-control" />
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="describe"> Mô tả diện tích </label>
                            <div class="col-sm-9">
                                <input type="text" id="describe" class="form-control" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="costrent"> Gía thuê </label>
                            <div class="col-sm-9">
                                <input type="number" id="costrent" class="form-control" name="costrent" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="priceDescription"> Mô tả giá </label>
                            <div class="col-sm-9">
                                <input type="text" id="priceDescription" class="form-control"  />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="serviceCharge"> Phí dịch vụ </label>
                            <div class="col-sm-9">
                                <input type="number" id="serviceCharge" class="form-control"  />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="overtimeFee"> Phí ngoài giờ </label>
                            <div class="col-sm-9">
                                <input type="number" id="overtimeFee" class="form-control"  />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="money"> Tiền điện </label>
                            <div class="col-sm-9">
                                <input type="number" id="money" class="form-control" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="cost"> Phí dịch vụ </label>
                            <div class="col-sm-9">
                                <input type="number" id="cost" class="form-control"  />
                            </div>
                        </div>


<%--                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="buildingTypes" > Loại tòa nhà </label>
                            <div class="col-sm-9">
                                <label class="checkbox-inline">
                                    <input type="checkbox" value="TANG_TRET" id="buildingTypes1" name=""  >Tầng trệt
                                </label>
                                <label class="checkbox-inline">
                                    <input type="checkbox" value="NGUYEN_CAN" id="buildingTypes2" name=""  >Nguyên căn
                                </label>
                                <label class="checkbox-inline">
                                    <input type="checkbox" value="NOI_THAT" id="buildingTypes3" name="" >Nội thất
                                </label>
                            </div>
                        </div>--%>


                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="note"> Ghi chú </label>
                            <div class="col-sm-9">
                                <textarea class="form-control" id="note" rows="6" name="note"  ></textarea>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-9 text-center">
                                <button type="button" class="btn btn-primary" id="btnAddBuilding" name="btnAddBuilding" >Add Building</button>
                                <button type="button" class="btn btn-primary" id="btnRemove" name="btnRemove"  >Remove</button>
                            </div>
                        </div>
                    </form>
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
