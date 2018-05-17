research relationships between tables in databases

draw out tables and link together to show relationship

3 types of relationships:

1 to 1
1 to many
many to many

tables are set up dependent on these relationships


one to one is simple but rare - eg order and order details where there is only one order per set of details   [ORDER]-[DETAILS]


one to many - eg jedi has more than one lightsaber but a lightsaber can only be owned by a single jedi, this uses the crows feet notation   [JEDI]-<LIGHTSABERS]

for relationships to work there needs to at least one attribute in common so that you can associate one entry from table 1 to one entry from table 2


many to many - zombies and victims, a zombie can bite lots of victims but also a victim can be bitten by lots of zombies, here we have double crows feet notation   [ZOMBIES]<->[VICTIMS]

this requires a joint table to be constructed so that you can reference entries from both tables:
[ZOMBIES]- -[VICTIMS]
         | |
         ^ ^
       [BITES]
