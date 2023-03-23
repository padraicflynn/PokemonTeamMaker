# PokemonTeamMaker

3/23/2023
This is our final project for the back end boot camp!
We have all our java, MySQL, and Springboot lessons come together here!

You can see this in action on youtube here: https://youtu.be/jjlfu10r-d0
I tried to keep the video under five minutes,
so forgive me if I talk a little fast but there was a lot to cover!

We have four tables!
A trainer table, comes with Gary and Lance preloaded for testing and convience. 
A user made teams table, which has the teams we make with their name, a description, and the trainer that owns the team.
A Pokemon in teams table, which is our join table. This lists all the teams we make and the Pokemon in them.
And a Pokedex table, which contains all the Pokemon we are working with, this is where the Pokemon in teams table gets the Pokemon.

We have an ERD showing the realionships in a visual format in the PNG file above, but breifly:
Many to Many: Many pokemon can be on many teams, and many teams can have many Pokemon.
One to many: Many trainers can have many teams, but a team can only have one trainer assigned to it. 

We have a lot RESTful endpoints we use too!
The User Made Teams table you can post/make a new team, delete a team, put/update a team's name, 
description and the trainer who owns it, and get/read all the teams in the database.

The Trainer table you can get the trainers by searching with their ID, make a new trainer, and delete a trainer.

Pokemon In teams table you can get a team by ID that will list the 
team name, ID, and all the Pokemon's names, ID and type that are in the team!
You can also add Pokemon to the team with the put/update feature. 
You can do this by entering what team by ID, and what Pokemon by ID you want to add!

You can also search the Pokedex in a few different ways!
You can search by a Pokemon name, or their ID, or get a whole list of Pokemon of each type!
You can also search by entering all three, this feature was more for my sake for testing things out.

I hope you enjoy seeing all that I've learned so far in Promineo tech's back end boot camp!
