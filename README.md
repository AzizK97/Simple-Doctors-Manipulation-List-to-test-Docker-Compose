# Doctor App - Simple Doctors Management System

A Java web application for managing doctors' information, built with servlets and deployed using Docker Compose with MySQL database and Tomcat server.

## 🏥 Features

- Add new doctors with complete information
- View list of all doctors
- Delete doctors from the system
- MySQL database integration
- Responsive web interface

## 🛠️ Technology Stack

- **Backend**: Java 17, Servlets, JDBC
- **Frontend**: JSP, HTML, CSS
- **Database**: MySQL 8.0
- **Server**: Apache Tomcat 9.0
- **Build Tool**: Maven
- **Containerization**: Docker & Docker Compose
- **Testing**: JUnit 5

## 📋 Prerequisites

Before running this application, make sure you have:

- [Docker](https://docs.docker.com/get-docker/) installed
- [Docker Compose](https://docs.docker.com/compose/install/) installed
- [Java 17+](https://adoptium.net/) installed (for development)
- [Maven 3.6+](https://maven.apache.org/install.html) installed (for development)

## 🚀 Quick Start

### 1. Clone the Repository

```bash
git clone https://github.com/AzizK97/Simple-Doctors-Manipulation-List-to-test-Docker-Compose.git
cd Simple-Doctors-Manipulation-List-to-test-Docker-Compose
```

### 2. Build the Application

```bash
cd doctorapp
mvn clean package
cd ..
```

### 3. Start the Application with Docker Compose

```bash
docker compose up -d
```

### 4. Access the Application

Open your web browser and navigate to:
```
http://localhost:8080/doctor-app/
```

## 📁 Project Structure

```
├── doctorapp/                     # Main Java application
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/doctor/
│   │   │   │       ├── dao/       # Data Access Objects
│   │   │   │       ├── model/     # Entity classes
│   │   │   │       ├── servlet/   # Servlet controllers
│   │   │   │       └── util/      # Utility classes
│   │   │   ├── resources/
│   │   │   │   └── create-table.sql  # Database schema
│   │   │   └── webapp/
│   │   │       ├── *.jsp          # JSP pages
│   │   │       └── WEB-INF/
│   │   │           └── web.xml    # Web configuration
│   │   └── test/                  # Unit tests
│   ├── pom.xml                    # Maven configuration
│   └── target/
│       └── doctor-app.war         # Built WAR file
├── docker-compose.yml             # Docker Compose configuration
├── Dockerfile                     # Docker image configuration
├── auth/                          # Registry authentication
└── README.md                      # This file
```

## 🐳 Docker Services

The application uses three Docker services:

### 1. MySQL Database (`mysql`)
- **Image**: `mysql:8.0`
- **Port**: `3306`
- **Database**: `hopital_db`
- **Credentials**: 
  - Root password: `rootpassword`
  - User: `user` / Password: `userpassword`

### 2. Tomcat Application Server (`tomcat`)
- **Image**: `tomcat:9.0`
- **Port**: `8080`
- **Deploys**: `doctor-app.war`

### 3. Docker Registry (`registry`)
- **Image**: `registry:2`
- **Port**: `7003`
- **Purpose**: Local container registry

## 🎯 Available Endpoints

| Endpoint | Method | Description |
|----------|---------|-------------|
| `/` | GET | Home page with navigation |
| `/add` | GET/POST | Add new doctor form |
| `/list` | GET | View all doctors |
| `/delete` | POST | Delete a doctor |

## 💾 Database Schema

The application uses a single table `medecin`:

```sql
CREATE TABLE medecin (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    specialite VARCHAR(100) NOT NULL,
    telephone VARCHAR(20),
    email VARCHAR(100),
    hopital VARCHAR(100)
);
```

## 🔧 Development

### Running Tests

```bash
cd doctorapp
mvn test
```

### Building the WAR file

```bash
cd doctorapp
mvn clean package
```

### Rebuilding and Redeploying

```bash
# Build new WAR file
cd doctorapp
mvn clean package
cd ..

# Restart the containers
docker compose restart tomcat
```

## 🐛 Troubleshooting

### Application Not Loading (404 Error)
1. Check if containers are running: `docker compose ps`
2. Check Tomcat logs: `docker compose logs tomcat`
3. Verify WAR file exists: `ls -la doctorapp/target/doctor-app.war`

### Database Connection Issues
1. Check if MySQL is running: `docker compose ps`
2. Verify database exists: 
   ```bash
   docker exec mysql_db mysql -u root -prootpassword -e "SHOW DATABASES;"
   ```
3. Check if table exists:
   ```bash
   docker exec mysql_db mysql -u root -prootpassword -e "USE hopital_db; SHOW TABLES;"
   ```

### Creating Database Table Manually (if needed)
```bash
docker exec mysql_db mysql -u root -prootpassword hopital_db -e "
CREATE TABLE IF NOT EXISTS medecin (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    specialite VARCHAR(100) NOT NULL,
    telephone VARCHAR(20),
    email VARCHAR(100),
    hopital VARCHAR(100)
);"
```

## 🛑 Stopping the Application

```bash
docker compose down
```

To remove all data (including database):
```bash
docker compose down -v
```

## 📝 Environment Variables

You can customize the application by modifying the `docker-compose.yml` file:

| Variable | Default | Description |
|----------|---------|-------------|
| `MYSQL_ROOT_PASSWORD` | `rootpassword` | MySQL root password |
| `MYSQL_DATABASE` | `hopital_db` | Database name |
| `MYSQL_USER` | `user` | Application database user |
| `MYSQL_PASSWORD` | `userpassword` | Application database password |

## 🧪 Testing the Application

1. **Add a Doctor**: 
   - Go to http://localhost:8080/doctor-app/
   - Click "Add Doctor" or navigate to `/add`
   - Fill the form and submit

2. **View Doctors**: 
   - Click "List Doctors" or navigate to `/list`

3. **Delete a Doctor**: 
   - From the doctors list, click delete button next to any doctor

## 📊 Monitoring

- **Application Health**: http://localhost:8080/doctor-app/
- **Tomcat Manager**: http://localhost:8080/manager (if enabled)
- **MySQL Database**: Connect to `localhost:3306` with MySQL client

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 👥 Authors

- **AzizK97** - *Initial work* - [GitHub Profile](https://github.com/AzizK97)

## 🙏 Acknowledgments

- Built for Docker Compose demonstration
- Uses standard Java EE technologies
- MySQL database integration
- Docker containerization best practices