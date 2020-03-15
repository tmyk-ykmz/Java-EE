<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <title>どこつぶ</title>
    <style type="text/css">
    <!--
        .emphasis {
            color: #ff0000;
        }
    -->
    </style>
    <script type="text/javascript">
        <!--htmlのコメントはこんな感じだが、なんでこれをコメントアウトにしたのか先生に聞きたい。
        //おそらく前の章では関係のあった章だったが、使わなくなったのでコメントアウトしたしかし本当にそうなのかわからない
        function clickBtn() {
            var pass = document.getElementById("pass");

            // 属性値を取得
            var stf = pass.getAttribute("type");

            // 属性値を設定
            if(stf == "password") {
                pass.setAttribute("type", "text");
            }else{
                pass.setAttribute("type", "password");
            }
        }
    -->
    </script>
</head>

<body>

    <h1>どこつぶへようこそ</h1>
    <p>
    <form action="/DocoTsubu13/Login" method="post">
    ユーザー名：<input type="text" name="name" required />
    <!--requiredは入力必須の意味-->
    <span class="emphasis">※ 入力必須</span><br />
    パスワード：<input type="password" name="pass" id="pass" />
    <span class="emphasis">※ 指定パスワード</span>
    <button type="button" onclick="clickBtn()">表示/非表示</button><br />
    <input type="submit" value="ログイン" />
    </form>
</body>
</html>