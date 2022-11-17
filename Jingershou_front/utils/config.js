var fileHost = "https://tradeplatform1.oss-cn-hangzhou.aliyuncs.com/"; //  在你当前小程序的后台的uploadFile 合法域名也要配上这个域名
var config = {  //阿里云的oss服务
  uploadImageUrl: `${fileHost}`, // 默认存在根目录，可根据需求改
  AccessKeySecret: 'vkIfo2dX8WjrVttFv6Px6Ck9b7pFkK', // AccessKeySecret
  OSSAccessKeyId: 'LTAI5tPzQFLdVPKQjkJeg2Zx', // AccessKeyId
  timeout: 87600 //上传文件时Policy的失效时间
};
module.exports = config
