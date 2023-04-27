let main = {
    init: function () {
        let _this = this;
        $('#btn-add').on('click', function () {
            _this.add();
        });
    },
    add: function (){
        let data = {
            menu: $('#menu').text(),
            content: $('#content').text(),
            price: $('#price').text()
        };

        $.ajax({
            type: 'POST',
            url: '/api/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function (){
            alert('장바구니에 추가되었습니다.')
            window.location.href = '/menu'
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    }
};

main.init();