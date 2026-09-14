Proceso TiendaEnLinea
	
	Definir precio1, precio2, precio3 Como Real
	Definir subtotal1, subtotal2, subtotal3 Como Real
	Definir subtotalGeneral, descuento Como Real
	Definir subtotalConDescuento, impuesto Como Real
	Definir envio, total Como Real
	Definir cantidad1, cantidad2, cantidad3 Como Entero
	Definir tipoCliente Como Entero
	Definir codigoPostal Como Caracter
	
	// Producto 1
	Repetir
		Escribir "Ingresa el precio del producto 1:"
		Leer precio1
		Si precio1 <= 0 Entonces
			Escribir "Error: el precio debe ser mayor que cero."
		FinSi
	Hasta Que precio1 > 0
	
	Repetir
		Escribir "Ingresa la cantidad del producto 1:"
		Leer cantidad1
		Si cantidad1 <= 0 Entonces
			Escribir "Error: la cantidad debe ser mayor que cero."
		FinSi
	Hasta Que cantidad1 > 0
	
	// Producto 2
	Repetir
		Escribir "Ingresa el precio del producto 2:"
		Leer precio2
		Si precio2 <= 0 Entonces
			Escribir "Error: el precio debe ser mayor que cero."
		FinSi
	Hasta Que precio2 > 0
	
	Repetir
		Escribir "Ingresa la cantidad del producto 2:"
		Leer cantidad2
		Si cantidad2 <= 0 Entonces
			Escribir "Error: la cantidad debe ser mayor que cero."
		FinSi
	Hasta Que cantidad2 > 0
	
	// Producto 3
	Repetir
		Escribir "Ingresa el precio del producto 3:"
		Leer precio3
		Si precio3 <= 0 Entonces
			Escribir "Error: el precio debe ser mayor que cero."
		FinSi
	Hasta Que precio3 > 0
	
	Repetir
		Escribir "Ingresa la cantidad del producto 3:"
		Leer cantidad3
		Si cantidad3 <= 0 Entonces
			Escribir "Error: la cantidad debe ser mayor que cero."
		FinSi
	Hasta Que cantidad3 > 0
	
	// Calcular subtotales
	subtotal1 <- calcularSubtotalProducto(precio1, cantidad1)
	subtotal2 <- calcularSubtotalProducto(precio2, cantidad2)
	subtotal3 <- calcularSubtotalProducto(precio3, cantidad3)
	
	subtotalGeneral <- calcularSubtotalGeneral(subtotal1, subtotal2, subtotal3)
	
	// Validar tipo de cliente
	Repetir
		Escribir "Selecciona el tipo de cliente:"
		Escribir "1. Cliente regular"
		Escribir "2. Cliente frecuente"
		Leer tipoCliente
		
		Si tipoCliente <> 1 Y tipoCliente <> 2 Entonces
			Escribir "Error: el tipo de cliente debe ser 1 o 2."
		FinSi
	Hasta Que tipoCliente = 1 O tipoCliente = 2
	
	descuento <- calcularDescuento(subtotalGeneral, tipoCliente)
	subtotalConDescuento <- subtotalGeneral - descuento
	
	// Validar código postal
	Repetir
		Escribir "Ingresa el código postal (5 dígitos):"
		Leer codigoPostal
		
		Si Longitud(codigoPostal) <> 5 Entonces
			Escribir "Error: el código postal debe contener exactamente 5 dígitos."
		FinSi
	Hasta Que Longitud(codigoPostal) = 5
	
	envio <- calcularEnvio(subtotalGeneral, codigoPostal)
	impuesto <- calcularImpuesto(subtotalConDescuento)
	
	total <- calcularTotal(subtotalGeneral, descuento, impuesto, envio)
	
	// Mostrar resultados
	Escribir "---------- RESUMEN DE COMPRA ----------"
	Escribir "Subtotal producto 1: $", subtotal1
	Escribir "Subtotal producto 2: $", subtotal2
	Escribir "Subtotal producto 3: $", subtotal3
	Escribir "Subtotal general: $", subtotalGeneral
	Escribir "Descuento: $", descuento
	Escribir "Impuesto: $", impuesto
	Escribir "Envío: $", envio
	Escribir "Total a pagar: $", total
	
FinProceso


Funcion resultado <- calcularSubtotalProducto(precio, cantidad)
	Definir resultado Como Real
	resultado <- precio * cantidad
FinFuncion


Funcion resultado <- calcularSubtotalGeneral(subtotal1, subtotal2, subtotal3)
	Definir resultado Como Real
	resultado <- subtotal1 + subtotal2 + subtotal3
FinFuncion


Funcion resultado <- calcularDescuento(subtotal, tipoCliente)
	Definir resultado Como Real
	
	Si tipoCliente = 2 Entonces
		resultado <- subtotal * 0.10
	SiNo
		resultado <- 0
	FinSi
FinFuncion


Funcion resultado <- calcularEnvio(subtotal, codigoPostal)
	Definir resultado Como Real
	
	// El código postal se recibe porque lo solicita el método.
	// El costo depende del subtotal antes del descuento.
	Si subtotal < 1000 Entonces
		resultado <- 150
	SiNo
		Si subtotal < 3000 Entonces
			resultado <- 80
		SiNo
			resultado <- 0
		FinSi
	FinSi
FinFuncion


Funcion resultado <- calcularImpuesto(subtotalConDescuento)
	Definir resultado Como Real
	resultado <- subtotalConDescuento * 0.16
FinFuncion


Funcion resultado <- calcularTotal(subtotal, descuento, impuesto, envio)
	Definir resultado Como Real
	resultado <- subtotal - descuento + impuesto + envio
FinFuncion