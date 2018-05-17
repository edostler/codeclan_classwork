superheroes = {
  iron_man: {
    name: "Tony Stark",
    attack_1: {
      attname: "punch",
      attpower: 10
    },
    attack_2: {
      attname: "kick",
      attpower: 100
    }
  },
  hulk: {
    name: "Bruce Banner",
    attack_1: {
      attname: "smash",
      attpower: 1000
    },
    attack_2: {
      attname: "roll",
      attpower: 500
    }
  }
}

character_1 = superheroes[:iron_man][:name]
character_2 = superheroes[:hulk][:name]
char_1_attack_1_attname = superheroes[:iron_man][:attack_1][:attname]
char_1_attack_1_attpower = superheroes[:iron_man][:attack_1][:attpower]

p "#{character_1} hits #{character_2} with their move #{char_1_attack_1_attname} inflicting a damage of #{char_1_attack_1_attpower}."


avengers = {
  iron_man: {
    name: "Tony Stark",
    moves: {
      punch: 10,
      kick: 100
    }
  },
  hulk: {
    name: "Bruce Banner",
    moves: {
      smash: 1000,
      roll: 500
    }
  }
}

character_1 = avengers[:iron_man][:name]
character_2 = avengers[:hulk][:name]
char_1_attack_1_attname = avengers[:iron_man][:attack_1][:attname]
char_1_attack_1_attpower = avengers[:iron_man][:attack_1][:attpower]

p "#{character_1} hits #{character_2} with their move #{char_1_attack_1_attname} inflicting a damage of #{char_1_attack_1_attpower}."
