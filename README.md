# Quests

## Architecture

The app architecture is based on the MVC pattern to separate
the app business logic, view and the app flow.

## Components

### Model layer
Components representing the app model. Placed in model package:
- Quest (abstract class, base class for CollectItemsQuest and KillMobsQuest)
- CollectItemsQuest (class represents specific quest for collecting items, inherits from Quest abstract class)
- KillMobsQuest (class represents specific quest for killing mobs, inherits from Quest abstract class)
- User (class represents user)
- QuestStatus (enum type for defining quest status)

### Data access layer:
Components responsible for accessing the data are placed in
dao package:
 - QuestDao (interface defines methods for accessing quests)
 - QuestDaoImpl (class implements QuestDao interface)
 - UserDao (interface defines methods for accessing users)
 - UserDaoImpl (class implements UserDao interface)

### Service layer:
Components responsible for executing business logic of the app. Placed
in service package:
- QuestService (interface defines methods for managing quests)
- QuestServiceImpl (class implements QuestService interface)
- UserService (interface defines methods for managing users)
- UserServiceImpl (class implements UserService interface)

### Controller layer:
Component responsible for managing flow of the app. It communicates
directly with view layer and service layer. Placed in controller package:
- ApplicationController

### View Layer
Component responsible for getting the user input and displaying data. Placed
in view package:
- ApplicationView

### Main class
Main app class responsible for creating all needed components and start the app:
- App

## Run Example
To run the app successfully data file with quest (quests.json) must be places
in data package in specified path: "src/main/java/org/example/data/quests.json".

Instructions:
- The user interact with the app by choosing given steps and providing the input in the form 
of numbers.

## Example Flow:

- The user enters 1 to choose an option to assign a quest to a user
- Then a lists of users and quests are displayed. The user is requested to
choose a user (by his id) to whom he wishes to assign a task.
- The user enters 3 to choose the user with id 3.
- Then he is requested to choose a given quest (by its id) he wants to assign to
the user with id 3.
- The user enters 3 to choose the quest with id 3. Quest is to collect 5 diamonds.
- When assigning quest with id 3 to the user with id 3 will be successful
the appropriate info will be displayed and the user will return to the previous
page (from now on the user with id 3 has an active quest with pending status).
- The user enters 3 to see status of active tasks. Quest status is PENDING with 0 items collected. The user is being
redirected to the main page automatically.
- The user enters 2 to update quest progress.
- The list with users with active quests will be displayed.
- The user is requested to select a user (by its id) whose quest progress
he wishes to update.
- The user enters 3 to choose active quest of the user with id 3.
- The user is requested to provide a specific amount by which he wants to update given quest progress.
- The user provide 5 to increase number of collected items by 5.
- The user completed his task. He collected 5/5 diamonds. The appropriate info
is displayed on the screen. The tasks status
is now COMPLETED and by now task is no longer assign to the user. The user is being redirected to the
main page automatically.
- The user enters 4 to see statuses for all existing tasks. The user is being redirected to the
main page automatically.
- The user enters 5 to close the app.

## Important
1. The user can only have one quest assigned. If the user with active quest will be
picked to assign him a quest, further operations will be aborted, an appropriate message will be displayed, and you will be redirected to the home page.
2. The quest which is already assigned (its status is PENDING) or completed can't be assigned. If the quest
with on of these statuses will be selected to assign it to the user, further operations will be aborted, an appropriate message will be displayed, and you will be redirected to the home page.
3. If the user enter the id to select a given quest or user (during assigning a quest, updating progress, etc.) but a user or a quest with given id doesn't exist
an appropriate message will be displayed, and you will be redirected to the home page.
4. Quest can't be completed manually. Quest will be completed automatically only after
progress will reach the desired value. Then the quest will be automatically detached from the given user. 

















