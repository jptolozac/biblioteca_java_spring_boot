
## API Reference

#### Registrar cliente

```
  POST http://localhost:8080/auth/register
```

| Parameter     | Type     | Description   |
| :--------     | :------- | :------------ |
| `cedula`      | `string` | **Required**. |
| `nombre`      | `string` | **Required**. |
| `correo`      | `string` | **Required**. |
| `contraseña`  | `string` | **Required**. |
| `telefono`    | `string` | **Required**. |
| `rol`         | `string` | **Required**. |

#### Pedir prestamo de un libro

```
  POST http://localhost:8087/prestamos
```

| Parameter         | Type        | Description   |
| :------------     | :-------    | :-----------  |
| `cliente_cedula`  | `string`    | **Required**. |
| `fecha_fin`       | `Date`      | **Required**. Fecha del fin del prestamo en formato "yyyy-mm-dd" |
| `libros_id`       | `Integer[]` | **Required**. Id de los libros que se van a prestar|

#### Consultar todos los libros

```
  GET http://localhost:8087/libros
```

#### Consultar libro por id

```
  GET http://localhost:8087/libros/${id}
```

| Parameter | Type     | Description                           |
| :-------- | :------- | :------------------------------------ |
| `id`      | `string` | **Required**. Id del libro a consutar |

#### Agregar libro 

```
  POST http://localhost:8087/libros/agregar
```

| Parameter | Type     | Description                           |
| :-------- | :------- | :------------------------------------ |
| `añoPublicacion`      | `string` | **Required**.  Fecha del año  de la publicación en formato "yyyy-mm-dd"  |
| `disponibilidad`      | `string` | **Required**. Disponibilidad |
| `titulo`      | `string` | **Required**. Título del libro |
| `autor`      | `int` | **Required**. Id del autor libro para  agregar |
| `categoria`      | `int` | **Required**. Id de la categoria libro para  agregar  |
| `editorial`      | `int` | **Required**. Id de la para  agregar  |

#### Editar libro 

```
  PUT http://localhost:8087/libros/editar
```

| Parameter | Type     | Description                           |
| :-------- | :------- | :------------------------------------ |
| `id`      | `int` | **Required**.  Id del  libro para  editar"  |
| `añoPublicacion`      | `string` |   Fecha del año  de la publicación en formato "yyyy-mm-dd"  |
| `disponibilidad`      | `string` |  Disponibilidad |
| `titulo`      | `string` |  Título del libro |
| `autor`      | `int` |  Id del autor libro para  agregar |
| `categoria`      | `int` | Id de la categoria libro para  agregar  |
| `editorial`      | `int` |  Id de la para  agregar  |

#### Eliminar libro 

```
  DELETE http://localhost:8087/libros/${id}
```

| Parameter | Type     | Description                           |
| :-------- | :------- | :------------------------------------ |
| `id`      | `int` | **Required**.  Id del  libro para  editar"  |

#### Consultar todos las Reseñas

```
  GET http://localhost:8087/reseña
```

#### Agregar Reseña 

```
  POST http://localhost:8087/reseña/agregar
```

| Parameter | Type     | Description                           |
| :-------- | :------- | :------------------------------------ |
| `descripcion`      | `string` | **Required**.  La descripcion correspondiente a la reseña |
| `titulo`      | `string` | **Required**. Como debe llamarse la reseña |
| `cliente_cedula`      | `string` | **Required**. Cedula del cliente a la cual pertenece la reseña |
| `libro_id`      | `int` | **Required**. Id del  libro para  agregar la reseña |






