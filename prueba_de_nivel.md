# Prueba de nivel

Aplicación de consola que recibe 1 contraseña por argumento. 

La aplicación debe calcular el nivel de fortaleza de contraseña y mostrárselo al usuario. 
En caso de que la puntuación sea inferior a 8 el usuario debe confirmar que quiere una contraseña débil. 

Al final del proceso el sistema debe mostrar si la contraseña ha sido aceptada. 
Se acepta si el nivel es superior a 8 o se ha confirmado la contraseña débil. 
El cálculo de la fortaleza de contraseña se calcula de la siguiente manera: 
Se asignará a la contraseña un valor numérico de 1 a 10. Siendo: 

    - 1 y 2: Muy débil 
    - 3 a 5: Débil 
    - 6 y 7: Moderada 
    - 8 y 9: Fuerte 
    - 10: muy fuerte 

El valor numérico se asigna de la siguiente forma: 

    - Longitud:  
        - De 0 a 6: 0 puntos 
        - 7 u 8 caracteres: 1 punto 
        - De 9 a 12: 2 puntos 
        - Más de 12: 3 puntos 

    - Uso de letras  
        - 1 punto 
    - Uso de mayúsculas y minúsculas  
        - Uso de ambas: 2 puntos 
    - Uso de números  
        - 1 punto 
    - Uso de símbolos  
        - 2 puntos

    - Combinación de máximo de puntos (máximo en longitud; uso de letras; mayúsculas y minúsculas; números;símbolos)  
        - 1 punto extra 

El umbral a partir del que el usuario debe confirmar (inicialmente 8) podría cambiar a posteriori. 
