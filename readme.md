
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

