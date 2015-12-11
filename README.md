# Sudoku Webservice

- Redis key-value store
- spring-boot
- spring-mvc
- RESTful Json

### Quick APIs Overview (Draft)

HttpMethod | path | description
------------ | ------------- | --------------
PUT | /sudoku/{level} | create a Game with the specified level (easy, medium, hard)
GET | /sudoku/{gameId} | load a running Game
POST | /sudoku/{gameId}/move | validate a Sudoku Move-Input

planned:

- different GUIs
-- text GUI (commandline)
-- javaFX
-- ....