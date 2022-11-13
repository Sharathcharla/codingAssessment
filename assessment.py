consecutive_number = 2  # Consecutive number is declared
IPL_Team_Scores = [  # Team points are taken in string list
    "GT-20-WWLLW",
    "LSG-18-WLLWW",
    "RR-16-WLWLL",
    "DC-14-WWLWL",
    "RCB-14-LWWLL",
    "KKR-12-LWWLW",
    "PBKS-12-LWLWL",
    "SRH-12-WLLLL",
    "CSK-8-LLWLW",
    "MI-6-LWLWW",
]
filtered_teams = []  # The Team which has 2 consecutive loses is taken to separate array

for team in IPL_Team_Scores:
    values = team.split("-")
    last_five_matches = values[2]
    score_arr = list(last_five_matches)

    consecutive_losses = 0

    for score in score_arr:
        if score == "L":
            consecutive_losses += 1
        else:
            consecutive_losses = 0
        if consecutive_losses == consecutive_number:
            filtered_teams.append(team)
            break

print(filtered_teams)
print("The number of teams those have 2 consecutive loses are ", len(filtered_teams))

points = []  # Here the points are of teams who have consecutive losses
for team in filtered_teams:
    values = team.split("-")
    team_points = values[1]

    points.append(int(team_points))

print("Average points are: ", int(sum(points) / len(filtered_teams)))
