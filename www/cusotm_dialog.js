// var exec = require('cordova/exec');

// exports.coolMethod = function (arg0, success, error) {
    // exec(success, error, 'cusotm_dialog', 'coolMethod', [arg0]);
// };
//cordova.define("cordova-plugin-dialog.CustomDialog",
    //function(require, exports, module) {
        var exec = require("cordova/exec");
        module.exports = {
            show: function(content){
                exec(
                function(message){//成功回调function
                    console.log(message);
                },
                function(message){//失败回调function
                    console.log(message);
                },
                "CustomDialog",//feature name
                "show",//action
                [content]//要传递的参数，json格式
                );
            }
        }
//});