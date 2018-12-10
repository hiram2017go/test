# weixin
比较简答的微信公众平台的制作
1.servlet 中url请求访问必须加value值，否则无法使用url访问，name只是个名字，value才是访问的值

### @javax.servlet.annotation.WebServlet(name = "WXServlet",value="/WXValue")

2.启动ngrok代理站点，使用 ngrok http 8888 / 这个8888是本地启动的站点端口