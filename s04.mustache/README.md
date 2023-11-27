## Mustache

Mustache es otro lenguaje de plantillas que está disponible a través de las dependencias de Spring Boot. Este es sin duda mucho más sencillo, y tal y como afirman los creadores se centra más en la presentación que en la lógica. También podría afirmarse que no tiene apenas herramientas para las expresiones lógicas.
En cualquier caso, Mustache es otra opción más, mucho más simple, que en el caso de Spring utiliza ficheros con extension .mustache alojados dentro del directorio templates.
En el siguiente ejemplo, se ha utilizado el mismo controlador que en el proyecto de ejemplo de Thymeleaf, pero aplicando una vista Mustache.

En este primer listado, una plantilla Mustache básica muestra un valor del modelo y además incluye en la cabecera y el pie otras plantillas. 

**Listado 1.1. Fichero simple.mustache.**

```html
<!DOCTYPE HTML>
<html>
<head>
<title>Spring Web : s04.mustache : simple</title>
	<meta charset="UTF-8">
</head>
<body>
	<header>
		{{>header}}
	</header>
	<main>
	
	<div>Say hello {{greet}}</div>
	</main>
	{{>footer}}
</body>
</html>
```

En el siguiente ejemplo, la misma página que muestra los datos de un cliente, en formato Mustache. No disponemos de expresiones lógicas salvo una forma primitiva de if-else.

**Listado - Fichero customer.mustache.**

```html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Spring Web : s04.mustache : simple</title>
	<meta charset="UTF-8">
</head>
<body>
	<header>
		<h1>Mustache Customer{{! This is a comment}}.</h1>
	</header>
	<main>
	<div>
 		<span>Hello {{customer.name}}</span>,
 		<span>{{customer.type.type}}</span>.
 	</div>
	<ul>
	{{#customer}}
<li><b>Name:</b> {{name}}.</li>
<li><b>Email:</b> {{email}}.</li>
<li><b>Birth:</b> {{birth}}.</li>
<li><b>Type:</b>  {{type.type}}.</li>
	{{/customer}}
</ul>

   {{^customer.accounts}}
   <div>No accounts</div>
   {{/customer.accounts}}
   
<div class="accounts">

 <table>
    <thead>
      <tr>
        <th>Id</th>
        <th>Bank</th>
        <th>Nº</th>
        <th>Active</th>
        <th>Balance</th>
      </tr>
    </thead>
    <tbody>
    {{#customer.accounts}}
    <tr>
      <td>{{id}}</td>
      <td>{{bank}<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Spring Web : s04.mustache : simple</title>
	<meta charset="UTF-8">
</head>
<body>
	<header>
		<h1>Mustache Customer{{! This is a comment}}.</h1>
	</header>
	<main>
	<div>
 		<span>Hello {{customer.name}}</span>,
 		<span>{{customer.type.type}}</span>.
 	</div>
	<ul>
	{{#customer}}
<li><b>Name:</b> {{name}}.</li>
<li><b>Email:</b> {{email}}.</li>
<li><b>Birth:</b> {{birth}}.</li>
<li><b>Type:</b>  {{type.type}}.</li>
	{{/customer}}
</ul>

   {{^customer.accounts}}
   <div>No accounts</div>
   {{/customer.accounts}}
   
<div class="accounts">

 <table>
    <thead>
      <tr>
        <th>Id</th>
        <th>Bank</th>
        <th>Nº</th>
        <th>Active</th>
        <th>Balance</th>
      </tr>
    </thead>
    <tbody>
    {{#customer.accounts}}
    <tr>
      <td>{{id}}</td>
      <td>{{bank}}</td>
      <td>{{number}}</td>
      <td>{{active}}</td>
      <td>{{balance}}</td>
  </tr>
  {{/customer.accounts}}
   </tbody>
   </table>

   </div>
	</main>
	<footer>
		<a href="/">Home</a> 
	</footer>
</body>
</html>}</td>
      <td>{{number}}</td>
      <td>{{active}}</td>
      <td>{{balance}}</td>
  </tr>
  {{/customer.accounts}}
   </tbody>
   </table>

   </div>
	</main>
	<footer>
		<a href="/">Home</a> 
	</footer>
</body>
</html>
```