Proceso ControlConsumoElectrico
	
	Definir lecturaAnterior, lecturaActual Como Real
	Definir consumo, costoConsumo, cargoFijo Como Real
	Definir costoAntesImpuesto, descuento Como Real
	Definir baseImponible, impuesto, total Como Real
	Definir opcionApoyo Como Entero
	Definir tieneApoyo Como Logico
	
	// Validar lectura anterior
	Repetir
		Escribir "Ingresa la lectura anterior del medidor:"
		Leer lecturaAnterior
		
		Si lecturaAnterior < 0 Entonces
			Escribir "Error: la lectura no puede ser negativa."
		FinSi
	Hasta Que lecturaAnterior >= 0
	
	// Validar lectura actual
	Repetir
		Escribir "Ingresa la lectura actual del medidor:"
		Leer lecturaActual
		
		Si lecturaActual < lecturaAnterior Entonces
			Escribir "Error: la lectura actual debe ser mayor o igual a la anterior."
		FinSi
	Hasta Que lecturaActual >= lecturaAnterior
	
	// Calcular consumo
	consumo <- calcularConsumo(lecturaAnterior, lecturaActual)
	
	// Validar consumo máximo
	Si consumo > 10000 Entonces
		Escribir "Error: el consumo máximo permitido es de 10,000 kWh."
	SiNo
		
		// Preguntar si tiene apoyo
		Repetir
			Escribir "¿La vivienda pertenece al programa de apoyo?"
			Escribir "1. Si"
			Escribir "2. No"
			Leer opcionApoyo
			
			Si opcionApoyo <> 1 Y opcionApoyo <> 2 Entonces
				Escribir "Error: selecciona 1 o 2."
			FinSi
		Hasta Que opcionApoyo = 1 O opcionApoyo = 2
		
		tieneApoyo <- opcionApoyo = 1
		
		// Cálculos
		costoConsumo <- calcularCostoConsumo(consumo)
		
		cargoFijo <- 95
		
		costoAntesImpuesto <- costoConsumo + cargoFijo
		
		descuento <- calcularDescuentoApoyo(
		consumo,
		costoAntesImpuesto,
		tieneApoyo
		)
		
		baseImponible <- costoAntesImpuesto - descuento
		
		impuesto <- calcularImpuesto(baseImponible)
		
		total <- calcularTotal(
		costoConsumo,
		cargoFijo,
		descuento,
		impuesto
		)
		
		// Mostrar recibo
		mostrarRecibo(
		consumo,
		costoConsumo,
		descuento,
		impuesto,
		total
		)
		
	FinSi
	
FinProceso


// Calcula el consumo mensual
Funcion resultado <- calcularConsumo(lecturaAnterior, lecturaActual)
	Definir resultado Como Real
	
	resultado <- lecturaActual - lecturaAnterior
FinFuncion


// Calcula el costo mediante bloques acumulativos
Funcion resultado <- calcularCostoConsumo(consumo)
	Definir resultado Como Real
	
	Si consumo <= 150 Entonces
		
		resultado <- consumo * 1.20
		
	SiNo
		
		Si consumo <= 400 Entonces
			
			resultado <- (150 * 1.20) + ((consumo - 150) * 1.80)
			
		SiNo
			
			resultado <- (150 * 1.20) + (250 * 1.80) + ((consumo - 400) * 2.75)
			
		FinSi
		
	FinSi
FinFuncion


// Calcula el descuento por pertenecer al programa de apoyo
Funcion resultado <- calcularDescuentoApoyo(consumo, costoAntesImpuesto, tieneApoyo)
	Definir resultado Como Real
	
	Si tieneApoyo Y consumo <= 250 Entonces
		resultado <- costoAntesImpuesto * 0.30
	SiNo
		resultado <- 0
	FinSi
FinFuncion


// Calcula el impuesto del 16 %
Funcion resultado <- calcularImpuesto(baseImponible)
	Definir resultado Como Real
	
	resultado <- baseImponible * 0.16
FinFuncion


// Calcula el total final
Funcion resultado <- calcularTotal(costoConsumo, cargoFijo, descuento, impuesto)
	Definir resultado Como Real
	
	resultado <- costoConsumo + cargoFijo - descuento + impuesto
FinFuncion


// Muestra el recibo
SubProceso mostrarRecibo(consumo, costoConsumo, descuento, impuesto, total)
	
	Escribir "---------- RECIBO DE ELECTRICIDAD ----------"
	Escribir "Consumo: ", consumo, " kWh"
	Escribir "Costo por consumo: $", costoConsumo
	Escribir "Cargo fijo: $95"
	Escribir "Descuento: $", descuento
	Escribir "Impuesto: $", impuesto
	Escribir "Total a pagar: $", total
	
FinSubProceso