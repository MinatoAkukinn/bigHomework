if(document.title == "主页面"){

    var i = 1;

    function Rcc() {
        eval(`btn${i}()`);
        i++;
        if (i > 4) {
            i = 1;
        }
    }
    
    var timer = setInterval(Rcc, 4000);
    
    function btn1() {
        document.getElementById('u296_state0').style.visibility = "visible";
        document.getElementById('u296_state1').style.visibility = "hidden";
        document.getElementById('u296_state2').style.visibility = "hidden";
        document.getElementById('u296_state3').style.visibility = "hidden";
    }
    
    function btn2() {
        document.getElementById('u296_state0').style.visibility = "hidden";
        document.getElementById('u296_state1').style.visibility = "visible";
        document.getElementById('u296_state2').style.visibility = "hidden";
        document.getElementById('u296_state3').style.visibility = "hidden";
    }
    
    function btn3() {
        document.getElementById('u296_state0').style.visibility = "hidden";
        document.getElementById('u296_state1').style.visibility = "hidden";
        document.getElementById('u296_state2').style.visibility = "visible";
        document.getElementById('u296_state3').style.visibility = "hidden";
    }
    
    function btn4() {
        document.getElementById('u296_state0').style.visibility = "hidden";
        document.getElementById('u296_state1').style.visibility = "hidden";
        document.getElementById('u296_state2').style.visibility = "hidden";
        document.getElementById('u296_state3').style.visibility = "visible";
    }
    
    function ele1() {
        btn1();
        clearInterval(timer);
        i = 2;
        timer = setInterval(Rcc, 4000);
    }
    
    function ele2() {
        btn2();
        clearInterval(timer);
        i = 3;
        timer = setInterval(Rcc, 4000);
    }
    
    function ele3() {
        btn3();
        clearInterval(timer);
        i = 4;
        timer = setInterval(Rcc, 4000);
    }
    
    function ele4() {
        btn4();
        clearInterval(timer);
        i = 1;
        timer = setInterval(Rcc, 4000);
    }
    
    document.getElementById('u302').addEventListener("click", ele1, true);
    
    document.getElementById('u303').addEventListener("click", ele2, true);
    
    document.getElementById('u304').addEventListener("click", ele3, true);
    
    document.getElementById('u305').addEventListener("click", ele4, true);
    
    window.addEventListener('load', timer, true)

}
else if(document.title == "商品详细页面"){

    //轮播图设置
    var k = 1;

    function BRCC() {
        eval(`bbtn${k}()`);
        k++;
        if (k > 3) {
            k = 1;
        }
    }

    var timer = setInterval(BRCC, 3000);
    
    function bbtn1(){
        //物品展示栏2
        document.getElementById('u427_state1').style.visibility = "visible";
        document.getElementById('u427_state2').style.visibility = "hidden";
        document.getElementById('u427_state3').style.visibility = "hidden";
        //物品展示栏1
        document.getElementById('u440_state0').style.visibility = "visible";
        document.getElementById('u440_state1').style.visibility = "hidden";
        document.getElementById('u440_state2').style.visibility = "hidden";
    }

    function bbtn2(){
        document.getElementById('u427_state1').style.visibility = "hidden";
        document.getElementById('u427_state2').style.visibility = "visible";
        document.getElementById('u427_state3').style.visibility = "hidden";

        document.getElementById('u440_state0').style.visibility = "hidden";
        document.getElementById('u440_state1').style.visibility = "visible";
        document.getElementById('u440_state2').style.visibility = "hidden";
    }

    function bbtn3(){
        document.getElementById('u427_state1').style.visibility = "hidden";
        document.getElementById('u427_state2').style.visibility = "hidden";
        document.getElementById('u427_state3').style.visibility = "visible";

        document.getElementById('u440_state0').style.visibility = "hidden";
        document.getElementById('u440_state1').style.visibility = "hidden";
        document.getElementById('u440_state2').style.visibility = "visible";
    }

    function bele1(){
        bbtn1();
        clearInterval(timer);
        k = 2;
        timer = setInterval(BRCC, 3000);
    }

    function bele2(){
        bbtn2();
        clearInterval(timer);
        k = 3;
        timer = setInterval(BRCC, 3000);
    }

    function bele3(){
        bbtn3();
        clearInterval(timer);
        k = 1;
        timer = setInterval(BRCC, 3000);
    }

    //原始->state1
    //428最后一张图片
    document.getElementById('u428').style.cursor = "pointer";
    document.getElementById('u429').style.cursor = "pointer";
    document.getElementById('u430').style.cursor = "pointer";
    document.getElementById('u428').addEventListener("click", bele3, true);
    document.getElementById('u429').addEventListener("click", bele2, true);
    document.getElementById('u430').addEventListener("click", bele1, true);

    //state1
    document.getElementById('u431').style.cursor = "pointer";//3
    document.getElementById('u432').style.cursor = "pointer";
    document.getElementById('u431').addEventListener("click", bele3, true);
    document.getElementById('u432').addEventListener("click", bele2, true);

    //state2
    document.getElementById('u434').style.cursor = "pointer";//3
    document.getElementById('u436').style.cursor = "pointer";
    document.getElementById('u434').addEventListener("click", bele3, true);
    document.getElementById('u436').addEventListener("click", bele1, true);

    //state3
    document.getElementById('u438').style.cursor = "pointer";//2
    document.getElementById('u439').style.cursor = "pointer";
    document.getElementById('u438').addEventListener("click", bele2, true);
    document.getElementById('u439').addEventListener("click", bele1, true);

    window.addEventListener('load', timer, true)

}