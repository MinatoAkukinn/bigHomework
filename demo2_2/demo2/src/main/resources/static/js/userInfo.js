//商品详细页面跳转
function toGooodsDT(){
    window.open("goodsDt.html","_self");
}

// document.write('<script type="text/javascript" src="js/main.js"></script>');
document.getElementById('u533').style.cursor = "pointer";
document.getElementById('u533').addEventListener('click',toGooodsDT,true);

//我的订单栏按钮跳转
function btn_type1() {
    document.getElementById('u564_state0').style.visibility = 'visible';
    document.getElementById('u564_state1').style.visibility = 'hidden';
    document.getElementById('u564_state2').style.visibility = 'hidden';
    document.getElementById('u564_state3').style.visibility = 'hidden';
}

function btn_type2() {
    document.getElementById('u564_state0').style.visibility = 'hidden';
    document.getElementById('u564_state1').style.visibility = 'visible';
    document.getElementById('u564_state2').style.visibility = 'hidden';
    document.getElementById('u564_state3').style.visibility = 'hidden';
}

function btn_type3() {
    document.getElementById('u564_state0').style.visibility = 'hidden';
    document.getElementById('u564_state1').style.visibility = 'hidden';
    document.getElementById('u564_state2').style.visibility = 'visible';
    document.getElementById('u564_state3').style.visibility = 'hidden';
}

function btn_type4() {
    document.getElementById('u564_state0').style.visibility = 'hidden';
    document.getElementById('u564_state1').style.visibility = 'hidden';
    document.getElementById('u564_state2').style.visibility = 'hidden';
    document.getElementById('u564_state3').style.visibility = 'visible';
}

//state1
document.getElementById('u568').style.cursor = "pointer";
document.getElementById('u569').style.cursor = "pointer";
document.getElementById('u570').style.cursor = "pointer";
document.getElementById('u568').addEventListener('click',btn_type2,true);
document.getElementById('u569').addEventListener('click',btn_type3,true);
document.getElementById('u570').addEventListener('click',btn_type4,true);

//state2
document.getElementById('u573').style.cursor = "pointer";
document.getElementById('u575').style.cursor = "pointer";
document.getElementById('u576').style.cursor = "pointer";
document.getElementById('u573').addEventListener('click',btn_type1,true);
document.getElementById('u575').addEventListener('click',btn_type3,true);
document.getElementById('u576').addEventListener('click',btn_type4,true);

//state3
document.getElementById('u579').style.cursor = "pointer";
document.getElementById('u580').style.cursor = "pointer";
document.getElementById('u582').style.cursor = "pointer";
document.getElementById('u579').addEventListener('click',btn_type1,true);
document.getElementById('u580').addEventListener('click',btn_type2,true);
document.getElementById('u582').addEventListener('click',btn_type4,true);

//state4
document.getElementById('u585').style.cursor = "pointer";
document.getElementById('u586').style.cursor = "pointer";
document.getElementById('u587').style.cursor = "pointer";
document.getElementById('u585').addEventListener('click',btn_type1,true);
document.getElementById('u586').addEventListener('click',btn_type2,true);
document.getElementById('u587').addEventListener('click',btn_type3,true);