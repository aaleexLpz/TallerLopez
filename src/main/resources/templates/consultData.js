function consultData() {
    fetch('consultData.php')
        .then(response => response.text())
        .then(data => {
            // Insertar los datos de la base de datos en la tabla
            document.querySelector('#tablaClientes tbody').innerHTML = data;
        })
        .catch(error => console.error('Error al obtener los datos de la base de datos:', error));
}