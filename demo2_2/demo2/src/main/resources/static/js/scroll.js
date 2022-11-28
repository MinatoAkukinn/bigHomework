if(document.title == "主页面")
{
    window.addEventListener('load',function(){
    let topPart = document.getElementById('u330')
    let topHeight = topPart.offsetHeight

    let navBar = document.getElementById('u315')
    let navHeight = navBar.offsetHeight

    window.addEventListener('scroll',function(){
        let scrollValue = document.documentElement.scrollTop
    //判断滚出去的距离是否大于第一部分的高度:
        if(scrollValue > topHeight) {
            navBar.style.position = 'fixed'
            navBar.style.left = '0px'
            navBar.style.top = '-34px'
        }else {
            navBar.style.position = 'absolute'
            navBar.style.top = '0px'
            // navBar.style.position = 'static'
        }
    })
})
}else if(document.title == "商品详细页面") {
    window.addEventListener('load',function(){

        let navBar = document.getElementById('u444')
        let navHeight = navBar.offsetHeight
    
        window.addEventListener('scroll',function(){
            let scrollValue = document.documentElement.scrollTop
        //判断滚出去的距离是否大于第一部分的高度:
            if(scrollValue >= 139) {
                navBar.style.zIndex=99;
                navBar.style.position = 'fixed'
                navBar.style.left = '0px'
                navBar.style.top = '0px'
            }else {
                navBar.style.position = 'absolute'
                navBar.style.top = '142px'
            }
        })
    })
}



//返回顶部
function topscroll(){
    scrollTo(0,0);
    // window.alert("你好");
    // console.log(1);
}