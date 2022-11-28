//菜单栏变换
//登录
document.getElementById('u470').style.cursor = "pointer";
document.getElementById('u470').addEventListener('click',function(){
    window.open("login.html","_self");
})

//注册
document.getElementById('u471').style.cursor = "pointer";
document.getElementById('u471').addEventListener('click',function(){
    window.open("register.html","_self");
})

//未登录我的订单
document.getElementById('u472').style.cursor = "pointer";
document.getElementById('u472').addEventListener('click',function(){
    window.open("login.html","_self");
})

//当商品详细页面载入时——判断是否登录
var temp = sessionStorage.getItem('uid');
function mainLoading(){
    if(temp==1000){
        document.getElementById("u467_state1").style.visibility = 'visible';
        document.getElementById('u467_state0').style.visibility = 'hidden';
    }
}
window.onload = mainLoading();

//用户中心
document.getElementById('u475').style.cursor = "pointer";
document.getElementById('u475').addEventListener('click',function(){
    window.open("userInfo.html","_self");
})

//已登录我的订单
document.getElementById('u476').style.cursor = "pointer";
document.getElementById('u476').addEventListener('click',function(){
    window.open("userInfo.html","_self");
})

//上传商品
document.getElementById('u477').style.cursor = "pointer";
document.getElementById('u477').addEventListener('click',function(){
    window.open("uploadGoodsInfo.html","_self");
})


//----------------------商品详细-评论-------------------------------------
function btn_state1() {
    document.getElementById('u366_state1').style.visibility = "visible";
    document.getElementById('u366_state0').style.visibility = "hidden";
}

function btn_state2() {
    document.getElementById('u366_state1').style.visibility = "hidden";
    document.getElementById('u366_state0').style.visibility = "visible";
}

//state1-评论
document.getElementById('u368').style.cursor = "pointer";
document.getElementById('u368').addEventListener("click",btn_state1,true);

//state2-商品详细
document.getElementById('u373').style.cursor = "pointer";
document.getElementById('u373').addEventListener("click",btn_state2,true);


//------------------------轮播图---------------------------
