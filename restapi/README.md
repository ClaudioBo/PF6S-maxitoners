# PF6S-Maxitoners > REST API
---
Proyecto final de 6to semestre de un sistema de manejo de inventarios simple conectado a una **REST API** 
Servicio hecho en PHP.

### Dependencias:
- ToroPHP - Framework para crear REST API's rapido

### Rutas
Las rutas de esta REST API son las siguientes:
**IMPORTANTE:** No es la mejor practica, pero como el proyecto es exclusivamente para el uso de un solo cliente/persona, y la API como esta hosteada, quise que tuviera un pequeño control de quien accedia a esto, se debe enviar en los headers lo siguiente:

    token: maxitoners2021-cJ0wK8uC7kK2aC8p

De igualmanera, el tema de la RESTAPI nos lo pidieron como requisito para entregar, y asi fue pero solo para no reprobar xd, pero en el caso del cliente no necesita tanta mamada, asi que al cliente se le entregara la version de solo Java con SQLite.
#### Obtener todos los productos
##### Request
`GET /producto/`

##### Respuesta
    {
        "status": true,
        "products": [
            {
                "id": 1,
                "nombre": "Toner Verde",
                "cantidad": 124,
                "precio": 100,
                "categoria": 2
            },
            {
                "id": 2,
                "nombre": "Cartucho impresora HP",
                "cantidad": 344,
                "precio": 360,
                "categoria": 1
            }
        ]
    }

#### Agregar un producto nuevo
##### Request
`POST /producto/`

##### Parametros
| Nombre | Tipo |
| ----------- | ----------- |
| nombre | string |
| cantidad | int |
| precio | double |
| categoria | int |

##### Respuesta
    {
        "status": true,
        "inserted_id": 15 #ID del producto nuevo
    }

#### Editar un producto existente
##### Request
`POST /producto/{id}`

##### Parametros
| Nombre | Tipo |
| ----------- | ----------- |
| nombre | string |
| cantidad | int |
| precio | double |
| categoria | int |

##### Respuesta
    {
        "status": true
    }

#### Borrar un producto existente
##### Request
`DELETE /producto/{id}`

##### Respuesta
    {
        "status": true
    }

