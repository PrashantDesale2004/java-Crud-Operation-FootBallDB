# java-Crud-Operation-FootBallDB
# Premier Zone Player Service

The **Premier Zone Player Service** is a Spring Boot application that provides a set of APIs to manage football player data, including retrieval, filtering, addition, update, and deletion of player records. The application uses a repository-based approach with Spring Data JPA for data management.

## Features
- Retrieve all players.
- Filter players by team, name, position, nationality, or a combination of team and position.
- Add new player records.
- Update existing player records.
- Delete player records by name.

---

## Table of Contents
1. [Technologies Used](#technologies-used)
2. [Project Structure](#project-structure)
3. [Endpoints](#endpoints)
4. [How to Run](#how-to-run)
5. [Usage Examples](#usage-examples)
6. [Contributing](#contributing)
7. [License](#license)

---

## Technologies Used
- **Java**: Programming language
- **Spring Boot**: Application framework
- **Spring Data JPA**: Database interaction
- **H2/MySQL/PostgreSQL**: For database storage (configurable)
- **Maven**: Dependency management

---

## Project Structure

---

## Endpoints

### Player Retrieval
1. **Get All Players**
    - **URL**: `/players`
    - **Method**: `GET`
    - **Description**: Retrieves a list of all players.

2. **Get Players by Team**
    - **URL**: `/players/team/{teamName}`
    - **Method**: `GET`
    - **Description**: Filters players by their team name.

3. **Get Players by Name**
    - **URL**: `/players/name/{searchText}`
    - **Method**: `GET`
    - **Description**: Searches players by their name.

4. **Get Players by Position**
    - **URL**: `/players/position/{searchText}`
    - **Method**: `GET`
    - **Description**: Filters players by their position.

5. **Get Players by Nationality**
    - **URL**: `/players/nation/{searchText}`
    - **Method**: `GET`
    - **Description**: Filters players by their nationality.

6. **Get Players by Team and Position**
    - **URL**: `/players/team/{team}/position/{position}`
    - **Method**: `GET`
    - **Description**: Filters players by their team and position.

### Player Management
7. **Add a Player**
    - **URL**: `/players`
    - **Method**: `POST`
    - **Description**: Adds a new player.
    - **Request Body**:
      ```json
      {
        "name": "Player Name",
        "team": "Team Name",
        "pos": "Position",
        "nation": "Nationality"
      }
      ```

8. **Update a Player**
    - **URL**: `/players`
    - **Method**: `PUT`
    - **Description**: Updates an existing player based on their name.
    - **Request Body**:
      ```json
      {
        "name": "Updated Name",
        "team": "Updated Team",
        "pos": "Updated Position",
        "nation": "Updated Nationality"
      }
      ```

9. **Delete a Player**
    - **URL**: `/players/{playerName}`
    - **Method**: `DELETE`
    - **Description**: Deletes a player by their name.

---

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/PrashantDesale2004/java-Crud-Operation-FootBallDB.git
   cd java-Crud-Operation-FootBallDB
