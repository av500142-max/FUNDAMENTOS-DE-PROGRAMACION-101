Algoritmo DepuracionRegistrosInteractivo
    Definir n Como Entero
    Escribir "Ingrese la cantidad de identificadores de transacciones:"
    Leer n
    
    Definir original, depurado, duplicados Como Entero
    Dimension original[n]
    Dimension depurado[n]
    Dimension duplicados[n]
    
    Definir i, j, k, tamDepurado, tamDup, eliminados Como Entero
    Definir yaExiste Como Logico
    
    Escribir "Ingrese los ", n, " identificadores:"
    Para i<-1 Hasta n Hacer
        Escribir " - Elemento ", i, ":"
        Leer original[i]
    FinPara
    
    tamDepurado <- 0
    tamDup <- 0
    eliminados <- 0
    
    // Proceso de depuración preservando el orden original
    Para i<-1 Hasta n Hacer
        yaExiste <- Falso
        Para j<-1 Hasta tamDepurado Hacer
            Si depurado[j] = original[i] Entonces
                yaExiste <- Verdadero
            FinSi
        FinPara
        
        Si No yaExiste Entonces
            tamDepurado <- tamDepurado + 1
            depurado[tamDepurado] <- original[i]
        Sino
            eliminados <- eliminados + 1
            Definir duplicadoRegistrado Como Logico
            duplicadoRegistrado <- Falso
            Para k<-1 Hasta tamDup Hacer
                Si duplicados[k] = original[i] Entonces
                    duplicadoRegistrado <- Verdadero
                FinSi
            FinPara
            Si No duplicadoRegistrado Entonces
                tamDup <- tamDup + 1
                duplicados[tamDup] <- original[i]
            FinSi
        FinSi
    FinPara
    
    // Mostrar resultados
    Escribir Sin Saltar "Arreglo original: ["
    Para i<-1 Hasta n Hacer
        Escribir Sin Saltar original[i]
        Si i < n Entonces Escribir Sin Saltar ", "; FinSi
    FinPara
    Escribir "]"
    
    Escribir Sin Saltar "Arreglo depurado: ["
    Para i<-1 Hasta tamDepurado Hacer
        Escribir Sin Saltar depurado[i]
        Si i < tamDepurado Entonces Escribir Sin Saltar ", "; FinSi
    FinPara
    Escribir "]"
    
    Escribir Sin Saltar "Identificadores duplicados: "
    Si tamDup > 0 Entonces
        Para i<-1 Hasta tamDup Hacer
            Escribir Sin Saltar duplicados[i]
            Si i < tamDup Entonces Escribir Sin Saltar ", "; FinSi
        FinPara
        Escribir ""
    Sino
        Escribir "Ninguno"
    FinSi
    
    Escribir "Registros eliminados: ", eliminados
    
FinAlgoritmo


