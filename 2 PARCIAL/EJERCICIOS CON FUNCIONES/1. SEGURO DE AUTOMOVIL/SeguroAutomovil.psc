Proceso SeguroAutomovil
	
	Definir valorVehiculo, tarifaBase Como Real
	Definir recargoEdad, recargoAccidentes Como Real
	Definir subtotal, descuento, costoFinal Como Real
	Definir edad, accidentes Como Entero
	Definir tieneSeguridad Como Logico
	
	// Validar valor del vehículo
	Repetir
		Escribir "Ingresa el valor del vehículo:"
		Leer valorVehiculo
		
		Si valorVehiculo <= 0 Entonces
			Escribir "Error: el valor debe ser mayor que cero."
		FinSi
	Hasta Que valorVehiculo > 0
	
	// Validar edad
	Repetir
		Escribir "Ingresa la edad del conductor:"
		Leer edad
		
		Si edad < 18 O edad > 100 Entonces
			Escribir "Error: la edad debe estar entre 18 y 100 años."
		FinSi
	Hasta Que edad >= 18 Y edad <= 100
	
	// Validar accidentes
	Repetir
		Escribir "Ingresa la cantidad de accidentes del último año:"
		Leer accidentes
		
		Si accidentes < 0 Entonces
			Escribir "Error: los accidentes no pueden ser negativos."
		FinSi
	Hasta Que accidentes >= 0
	
	Escribir "¿El vehículo cuenta con sistema de seguridad adicional?"
	Escribir "Escribe Verdadero o Falso:"
	Leer tieneSeguridad
	
	// Llamada a métodos
	tarifaBase <- calcularTarifaBase(valorVehiculo)
	recargoEdad <- calcularRecargoPorEdad(tarifaBase, edad)
	recargoAccidentes <- calcularRecargoPorAccidentes(tarifaBase, accidentes)
	
	subtotal <- tarifaBase + recargoEdad + recargoAccidentes
	
	descuento <- calcularDescuentoSeguridad(subtotal, tieneSeguridad)
	costoFinal <- calcularCostoFinal(tarifaBase, recargoEdad, recargoAccidentes, descuento)
	
	Escribir "---------- COTIZACIÓN ----------"
	Escribir "Tarifa base: $", tarifaBase
	Escribir "Recargo por edad: $", recargoEdad
	Escribir "Recargo por accidentes: $", recargoAccidentes
	Escribir "Descuento por seguridad: $", descuento
	Escribir "Costo anual final: $", costoFinal
	
FinProceso


Funcion resultado <- calcularTarifaBase(valorVehiculo)
	Definir resultado Como Real
	resultado <- valorVehiculo * 0.04
FinFuncion


Funcion resultado <- calcularRecargoPorEdad(tarifaBase, edad)
	Definir resultado Como Real
	
	Si edad < 25 Entonces
		resultado <- tarifaBase * 0.20
	SiNo
		Si edad > 60 Entonces
			resultado <- tarifaBase * 0.10
		SiNo
			resultado <- 0
		FinSi
	FinSi
FinFuncion


Funcion resultado <- calcularRecargoPorAccidentes(tarifaBase, accidentes)
	Definir resultado Como Real
	resultado <- tarifaBase * 0.08 * accidentes
FinFuncion


Funcion resultado <- calcularDescuentoSeguridad(subtotal, tieneSeguridad)
	Definir resultado Como Real
	
	Si tieneSeguridad Entonces
		resultado <- subtotal * 0.05
	SiNo
		resultado <- 0
	FinSi
FinFuncion


Funcion resultado <- calcularCostoFinal(tarifaBase, recargoEdad, recargoAccidentes, descuento)
	Definir resultado Como Real
	resultado <- tarifaBase + recargoEdad + recargoAccidentes - descuento
FinFuncion