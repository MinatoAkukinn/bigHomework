//获取登录密码
let pwd1 = formName.inputName1.value;
//获取确认密码
let pwd2 = formName.inputName2.value;

if(pwd1!=pwd2){
    alert("两次密码不一致，请重新输入!");
}