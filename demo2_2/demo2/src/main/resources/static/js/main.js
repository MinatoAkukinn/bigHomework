// //当主页面载入
// var temp = sessionStorage.getItem('uid');
//
// function mainLoading(){
//     if(temp!=null){
//         document.getElementById("u335_state1").style.visibility = 'visible';
//         document.getElementById('u335_state0').style.visibility = 'hidden';
//     }
// }
// window.onload = mainLoading();

//上传商品判断
function uploadGoods(){
    if(temp!=null){
        window.open("uploadGoodsInfo.html","_self");
    }
    else{
        window.open("login.html","_self");
    }
}


