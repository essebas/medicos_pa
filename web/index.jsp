<%-- 
    Document   : index
    Created on : 02-jun-2019, 8:00:39
    Author     : zebas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="Templates/head.jsp"></jsp:include>
    <body>
        <div class="ui middle aligned center aligned grid">
            <div class="column">
                <h2 class="ui teal image header">
                    <i class="stethoscope icon"></i>
                    <div class="content">
                        Ingreso
                    </div>
                </h2>
                <form class="ui large form">
                    <input type="hidden" name="action" value="login">
                    <div class="ui stacked segment">
                        <div class="field">
                            <div class="ui left icon input">
                                <i class="user icon"></i>
                                <input type="text" name="cedula" id="cedula" placeholder="Document">
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui left icon input">
                                <i class="lock icon"></i>
                                <input type="password" name="clave" id="clave" placeholder="Password">
                            </div>
                        </div>
                        <button class="ui fluid large teal submit button" id="login">Login</button>
                    </div>

                    <div class="ui error message"></div>

                </form>

                <div class="ui message">
                    ¿Olvidaste tu contraseña? <a href="#">Recuperar</a>
                </div>
                <div class="ui message" id="resultado">

                </div>
            </div>
        </div>

        <div class="ui mini modal" style="display: block !important;">
            <div class="header">
                Delete Your Account
            </div>
            <div class="content">
                <p>Are you sure you want to delete your account</p>
            </div>
            <div class="actions">
                <div class="ui negative button">
                    No
                </div>
                <div class="ui positive right labeled icon button">
                    Yes
                    <i class="checkmark icon"></i>
                </div>
            </div>
        </div>

        <div class="ui dimmer" id="loader">
            <div class="ui loader"></div>
        </div>

        <script type="text/javascript">
            var user_action;
            var user_cedula;
            var user_clave;
            var ajax = new XMLHttpRequest();

            $(document).ready(function () {
                $('#login').click(function () {
                    alert("Data Loaded: ");
                    user_action = 'login';
                    user_cedula = $('#cedula').val();
                    user_clave = $('#clave').val();

                    /*$.get('UsuarioController', {action: user_action, cedula: user_cedula, clave: user_clave})
                     .done(function (data) {
                     alert("Data Loaded: " + data);
                     });
                     
                     ajax.onreadystatechange = function () {
                     if (this.readyState === 4 && this.status === 200) {
                     window.location.href = 'welcome.jsp';
                     } else {                        
                     alert(ajax.responseText);
                     }
                     ;
                     };
                     ajax.open('POST', 'UsuarioController', true);
                     ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                     ajax.send('action=' + user_action + '&cedula=' + user_cedula + '&clave=' + user_clave);*/
                    /*$.post('UsuarioController', {action:user_action, cedula: user_cedula, clave: user_clave}, function (html) {                        
                     $('.mini.modal').modal('show');                     
                     window.location.href = 'welcome.jsp';
                     });*/
                    $.ajax({
                        type: 'POST',
                        url: 'UsuarioController',
                        data: {action: user_action, cedula: user_cedula, clave: user_clave},
                        dataType: 'text',
                        success: function (data) {
                            alert(data);
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            console.log("Something really bad happened "
                                    + textStatus + ";" + errorThrown);
                        }
                    });
                });
            });
            $('.mini.modal').modal();
        </script>
    </body>
</html>
