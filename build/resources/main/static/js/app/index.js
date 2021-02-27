var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {    // btn-save 라는 id를 가진 HTML element가 click 이벤트가 발생할 때
            _this.save();                           // save function을 실행하도록 이벤트를 등록
        });
        $('#btn-update').on('click', function() {   // btn-update 라는 id를 가진 HTML element가 click 이벤트가 발생할 때
            _this.update();                         // update function을 실행하도록 이벤트를 등록
        });
        $('#btn-delete').on('click', function() {   // btn-delete 라는 id를 가진 HTML element가 click 이벤트가 발생할 때
            _this.delete();                         // delete function을 실행하도록 이벤트를 등록
        });
    },
    save : function () {
        var data = {
            title: $('#title').val(),   // title 이라는 id를 가진 HTML element의 값을 title에 저장
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',   // HTTP 요청 방식 -> PostApiController에 있는 API에서 @PostMapping으로 선언했기 때문
            url: '/api/v1/posts',   // 클라이언트가 요청을 보낼 서버의 URL주소
            dataType: 'json',   // 서버에서 보내줄 데이터의 타입
            data: JSON.stringify(data),  // HTTP 요청과 함께 서버(컨트롤러)로 보낼 데이터 //  JSON.stringify() ->  json 객체를 String 객체로 변환
            contentType:'application/json; charset=utf-8'   // 컨트롤러는 String타입의 데이터를 받게 되며, 이때 전달한 String데이터는 JSON형태로 이루어진
                                                            // 데이터임을 알려주기위하여 contentType 속성값을 "application/json"로 지정하는 것
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function() {
        var data = {    // Javascript 객체, JSON은 Javascript의 객체 표기법을 제한하여 만든 텍스트 기반의 데이터 교환 표준
            title: $('#title').val(),   // id가 title인 값을 title에 저장
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/' + id,  // 어느 게시글을 수정할지 URL Path로 구분하기 위해 Path에 id를 추가
            dataType: 'json',   // 서버에서 보내줄 데이터의 타입
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)  // HTTP 요청과 함께 서버로 보낼 데이터
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            //contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();