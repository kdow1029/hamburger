let main = {
    init: function () {
        let _this = this;
        $('#btn-add').on('click', function () {
            _this.add();
        });
        $('#btn-update').on('click', function (){
            _this.update();
        });
        $('#btn-addCart').on('click', function (){
            _this.addCart();
        });
        $(document).ready(function(){

            calculateToalPrice();

            $("#count").change( function(){
                calculateToalPrice();
            });
        });

        function calculateToalPrice(){
            let count = $("#count").val();
            let price = $("#price").val();
            let totalPrice = price*count;
            $("#totalPrice").html(totalPrice + '원');
        }
    }
    ,

    add: function (){

        let token = $("meta[name='_csrf']").attr("content");
        let header = $("meta[name='_csrf_header']").attr("content");
        let url = '/api/add';
        let data = {
            id: $('#orderId').val(),
            menu: $('#menu').text(),
            content: $('#content').text(),
            price: $('#price').text(),
            count: $('#count').val()
        };

        let param = JSON.stringify(data);

        $.ajax({
            url: url,
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data     : param,
            beforeSend : function(xhr){
                /* 데이터를 전송하기 전에 헤더에 csrf값을 설정 */
                xhr.setRequestHeader(header, token);
            },
            cache   : false,
            success  : function(){
                alert("추가")
                location.href = '/menu';
            },
            error : function(jqXHR,error){
                // if(jqXHR.status == '401'){
                //     alert('로그인 후 이용해주세요');
                //     location.href='/members/login';
                // } else{
                //     alert(jqXHR.responseText);
                //     console.log(error)
                // }
            }
        });
    },
    // addCart :function(){
    //     let token = $("meta[name='_csrf']").attr("content");
    //     let header = $("meta[name='_csrf_header']").attr("content");
    //
    //     let url = "/cart";
    //     let data = {
    //         id: $('#orderId').val(),
    //         menu: $('#menu').text(),
    //         count: $('#count').val()
    //     };
    //
    //     let param = JSON.stringify(data);
    //
    //     $.ajax({
    //         url: url,
    //         type: "POST",
    //         contentType: "application/json",
    //         data: param,
    //         beforeSend: function (xhr) {
    //         /* 데이터를 전송하기 전에 헤더에 csrf값을 설정 */
    //             xhr.setRequestHeader(header, token);
    //         },
    //         dataType: "json",
    //         cache: false,
    //         success: function () {
    //             alert("상품을 장바구니에 담았습니다.");
    //             location.href = '/menu';
    //         },
    //         error: function (error){
    //             console.log(error);
    //         }
    //     });
    // }
};

main.init();