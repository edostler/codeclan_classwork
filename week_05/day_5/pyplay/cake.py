class Cake:
    def __init__(self, name, ingredients):
        self.name = name
        self.ingredients = ingredients

    def bake(self):
        return "We're baking a " + self.name + "!"
