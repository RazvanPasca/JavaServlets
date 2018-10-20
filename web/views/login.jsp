<%--
  Created by IntelliJ IDEA.
  User: ratga
  Date: 10/18/2018
  Time: 8:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="../assets/css/login.css" media="screen"/>
  <link rel="stylesheet" type="text/css" href="../assets/css/mui.css" media="screen"/>
  <link rel="stylesheet" type="text/css"
        href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css" media="screen"/>
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Pacifico" media="screen"/>
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/icon?family=Material+Icons"
        media="screen"/>
  <meta charset="utf-8">
  <title>Login to Celyes</title>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"
          type="text/javascript"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"
          type="text/javascript"></script>
  <script src="../assets/js/login.js" type="text/javascript"></script>
</head>
<body class="login-body">
<div class="row">
  <div class="input-cart col s12 m10 push-m1 z-depth-2 grey lighten-5">
    <div class="col s12 m5 login">
      <h4 class="center">Log in</h4>
      <br>
      <form action="j_security_check" method="post" autocomplete="on">
        <div class="row">
          <div class="input-field">
            <input type="text" id="user" name="j_username" class="validate" required="required"
                   placeholder="Username">
            <label for="user">
              <i class="material-icons">person</i> </label>
          </div>
        </div>
        <div class="row">
          <div class="input-field">
            <input type="password" id="pass" name="j_password" class="validate" required="required"
                   placeholder="Password">
            <label for="pass">
              <i class="material-icons">lock</i>
            </label>
          </div>
        </div>
        <div class="row">
          <div class="switch col s6">
            <label>
              <input type="checkbox">
              <span class="lever"></span>
              Remember Me
            </label>
          </div>
          <div class="col s6">
            <button type="submit" name="login" class="btn waves-effect waves-light blue right">Log in
            </button>
          </div>
        </div>
      </form>
    </div>
    <!-- Signup form -->
    <div class="col s12 m7 signup">
      <div class="signupForm">
        <h4 class="center">Sign up</h4>
        <br>
        <form action="regCheck.php" name="signup" method="post" autocomplete="off">
          <div class="row">
            <div class="input-field col s12 m6">
              <input type="text" id="name-picked" name="namepicked" class="validate" required="required"
                     placeholder="Enter a username">
              <label for="name-picked">
                <i class="material-icons">person_add</i>
              </label>
            </div>
            <div class="input-field col s12 m6">
              <input type="password" id="pass-picked" name="passpicked" class="validate"
                     required="required" placeholder="Password">
              <label for="pass-picked">
                <i class="material-icons">lock</i> </label>
            </div>
          </div>
          <div class="row">
            <div class="input-field email">
              <div class="col s12">
                <input type="text" id="email" name="email" class="validate" required="required"
                       placeholder="Enter your email">
                <label for="email">
                  <i class="material-icons">mail</i>
                </label>
              </div>
            </div>
          </div>
        </form>
        <div class="row">
          <button type="submit" name="btn-signup" class="btn blue right waves-effect waves-light">Sign Up
          </button>
        </div>
      </div>
      <div class="signup-toggle center">
        <h4 class="center">Have No Account ? <a href="#!">Sign Up</a></h4>
      </div>
    </div>
    <div class="col s12">
      <br>
      <div class="legal center">
      </div>
      <div class="legal center">
        <div class="col s12 m7 right">
          <p class="grey-text policy center">By signing up, you agree on our <a href="#!">Privacy Policy</a>
            and <a href="#!">Terms of Use</a> including <a href="#!">Cookie Use</a>.</p>
        </div>
        <div class="col s12 m5">
          <p class="center grey-text" style="font-size: 14px;">Coding : <a href="http://fb.com/celyes17"
                                                                           class="main-title red-text"
                                                                           target="_blank">Gabi</a></p>
        </div>
      </div>

    </div>
  </div>
</div>
<div class="fixed-action-btn toolbar">
  <a class="btn-floating btn-large amber black-text">
    Login
  </a>
  <ul>
    <li><a class="indigo center" href="#!">Login with FB</a></li>
    <li><a class="blue center" href="#!">Login with Twitter</a></li>
    <li><a class="red center" href="#!">Login with Google +</a></li>
  </ul>
</div>
</body>
</html>