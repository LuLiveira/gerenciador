<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	
	Bem-vindo! <c:if test="${not empty usuarioLogado}"> ${usuarioLogado.email}
	</c:if>
	<form action="novaEmpresa" method="post">
		Nome: <input type="text" name="nome"> <input type="submit"
			value="Enviar">
	</form>
	<form action="login" method="post">
		Email: <input type="email" name="email"> Senha: <input
			type="password" name="senha"> <input type="submit"
			value="Enviar">
	</form>
	<form action="logout" method="post">
		<input type="submit" value="Deslogar">
	</form>
</body>
</html>