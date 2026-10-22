Algoritmo AnalisisVentasInteractivo
    Definir numSucursales Como Entero
    Escribir "Ingrese la cantidad de sucursales a analizar:"
    Leer numSucursales
    
    Definir sucursales Como Caracter
    Dimension sucursales[numSucursales]
    
    Definir ventas Como Real
    Dimension ventas[numSucursales, 12]
    
    Definir meses Como Caracter
    Dimension meses[12]
    meses[1] <- "Ene"; meses[2] <- "Feb"; meses[3] <- "Mar"; meses[4] <- "Abr"
    meses[5] <- "May"; meses[6] <- "Jun"; meses[7] <- "Jul"; meses[8] <- "Ago"
    meses[9] <- "Sep"; meses[10] <- "Oct"; meses[11] <- "Nov"; meses[12] <- "Dic"
	
    Definir ventasAnuales Como Real
    Dimension ventasAnuales[numSucursales]
    
    Definir sumaGlobal, promedioGlobal, totalAnual, maxVenta Como Real
    Definir i, j, mesMax Como Entero
    
    // Capturar datos del usuario
    Para i<-1 Hasta numSucursales Hacer
        Escribir "Ingrese el nombre de la sucursal ", i, ":"
        Leer sucursales[i]
        Escribir "Ingrese las ventas de los 12 meses para ", sucursales[i], ":"
        Para j<-1 Hasta 12 Hacer
            Escribir " - Mes ", meses[j], ":"
            Leer ventas[i,j]
        FinPara
    FinPara
	
    sumaGlobal <- 0
    Escribir ""
    Escribir "=== REPORTE DE VENTAS POR SUCURSAL ==="
    Para i<-1 Hasta numSucursales Hacer
        totalAnual <- 0
        maxVenta <- ventas[i,1]
        mesMax <- 1
        
        Para j<-1 Hasta 12 Hacer
            totalAnual <- totalAnual + ventas[i,j]
            Si ventas[i,j] > maxVenta Entonces
                maxVenta <- ventas[i,j]
                mesMax <- j
            FinSi
        FinPara
        
        ventasAnuales[i] <- totalAnual
        sumaGlobal <- sumaGlobal + totalAnual
        
        Escribir "Sucursal: ", sucursales[i]
        Escribir " - Total Anual: $", totalAnual
        Escribir " - Promedio Mensual: $", (totalAnual / 12)
        Escribir " - Mejor Mes: ", meses[mesMax], " ($", maxVenta, ")"
    FinPara
	
    promedioGlobal <- sumaGlobal / numSucursales
    Escribir "----------------------------------------"
    Escribir "Promedio Global Anual: $", promedioGlobal
    
    Escribir "Sucursales que superan el promedio global:"
    Para i<-1 Hasta numSucursales Hacer
        Si ventasAnuales[i] > promedioGlobal Entonces
            Escribir " > ", sucursales[i], " ($", ventasAnuales[i], ")"
        FinSi
    FinPara
FinAlgoritmo

