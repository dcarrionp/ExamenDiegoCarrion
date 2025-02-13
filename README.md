# ExamenDiegoCarrion
 Examen Final Sistemas Distribuidos
 Por: Diego Andres Carrion Portilla

# Microservicio de Universidades con Spring Boot, Docker y Kubernetes

## Descripción
Este proyecto implementa un microservicio REST para gestionar universidades, utilizando:
- **Spring Boot** (Java) para la API.
- **PostgreSQL** como base de datos.
- **Docker** para containerización.
- **Kubernetes** para despliegue en cluster.

## Estructura del Repositorio

.
├── k8s/
│ ├── database-deployment.yaml
│ ├── database-service.yaml
│ ├── microservice-deployment.yaml
│ ├── microservice-service.yaml
│ └── postgres-pvc.yaml
├── src/ # Código fuente Spring Boot
├── Dockerfile
├── docker-compose.yml
└── README.md


## Tareas Implementadas

### Tarea 1: Microservicio Spring Boot
**Endpoint principal**: `/api/universidades`  
**Operaciones CRUD**:
- `GET /api/universidades`: Listar todas
- `GET /api/universidades/{id}`: Buscar por ID
- `POST /api/universidades`: Crear nueva
- `PUT /api/universidades/{id}`: Actualizar
- `DELETE /api/universidades/{id}`: Eliminar

**Configuración de BD** (application.properties):
```properties
spring.datasource.url=jdbc:postgresql://database:5432/universidades
spring.datasource.username=postgres
spring.datasource.password=postgres

### Tarea 2: Dockerización

FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

- `docker-compose up --build`

### Tarea 3: Despliegue en Kubernetes
- Archivos YAML:

- Base de Datos (PostgreSQL):

- Deployment: database-deployment.yaml

- Service: database-service.yaml

- PVC: postgres-pvc.yaml

#### Microservicio:

- Deployment: microservice-deployment.yaml

- Service: microservice-service.yaml

# Aplicar configuración
kubectl apply -f k8s/

# Verificar estado
kubectl get pods,deployments,services,pvc

# Acceder al microservicio
minikube service microservice --url  # Para Minikube




