# start with general requirements of runner file
#
# begin by asking the user to configure their bar, this:
# - asks the user to name the bar
# - asks the user to pick 2 song packages to add to the bar (*** hardcode the packages in runner? probably a better way once we look at databases ***)
# - asks the user to state how many rooms they want
# --- asks the user to set a name for each room
# --- asks the user to set a capacity for each room
# --- asks the user to add up to 3 songs to each room or to 'randomise' song selection for quick setup
# - asks the user to state how much cash is currently in the till
# - asks the user to state how many drinks are currently in the stock
# - confirms to them the current configuration of the bar
#
# the runner then moves the user into live mode where they are given the options of:
# 1 - to check-in a guest
# 2 - to check-out a guest
# 3 - add a song to a room
# 4 - remove a song from a room
# 5 - take a drinks order
# 6 - to view room capacities
# 7 - to view the till
# 8 - to view the stock
# ---
# 9 - to reconfigure bar (*** leave this as an extension unless I have time ***)
