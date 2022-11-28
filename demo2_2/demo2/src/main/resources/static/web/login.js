$("#u62").click(function () {
    $.ajax({
        url:"/users/reg",
        type:"POST",
        data:$("#form-reg").serialize(),

        dataType:"JSON",

        success: function (json) {
            if(json.state == 200)
            {
                alert("注册成功")
            }
            else {
                alert("注册失败")
            }
        },

        error : function(xhr) {
            alert("注册时产生未知的错误！"+xhr.status);
        }
    })
})