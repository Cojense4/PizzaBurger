## Running the Project with Docker

To run the Pizza Burger Ordering System using Docker, follow these steps:

1. **Build and Start Services:**
   Use Docker Compose to build and start the services defined in the `docker-compose.yaml` file:
   ```bash
   docker-compose up --build
   ```

2. **Access the Application:**
   - The main application will be accessible at `http://localhost:8080`.
   - Ensure port `8080` is not in use by other applications.

3. **Database Configuration:**
   - The PostgreSQL database service is configured with the following environment variables:
     - `POSTGRES_USER`: `user`
     - `POSTGRES_PASSWORD`: `password`
     - `POSTGRES_DB`: `pizza_burger_db`
   - Data is persisted in the `db_data` volume.

4. **Stop Services:**
   To stop the services, use:
   ```bash
   docker-compose down
   ```

Ensure Docker and Docker Compose are installed on your system before proceeding. For further details, refer to the Docker documentation.