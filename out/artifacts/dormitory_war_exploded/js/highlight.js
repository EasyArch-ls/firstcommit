/*
 * 作者:helang
 * 邮箱:helang.love@qq.com
 * 微信公众号:web-7258
 */

;$.extend({
    highlight:function (str,params) {
        var reg=new RegExp(("("+params.keys+")"),"gm");
        var color=params.color || '#f00';
        var weight=params.weight ? 'bold':'normal';
        var replace='<span style="color:'+color+';font-weight: '+weight+';">$1</span>';
        return str.replace(reg,replace);
    }
});