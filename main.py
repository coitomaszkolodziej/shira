import random
import psycopg2
import sys

def generateArtists(n):
    conn_string = "host='localhost' dbname='artistsandsongs' user='admin' password='admin'"
    print "Connecting to database\n	->%s" % (conn_string)
    conn = psycopg2.connect(conn_string)
    cursor = conn.cursor()


    print "Connected!\n"
    namesFile = open("C:\\Users\Praktyki\Desktop\\names.txt", "r")
    surnamesFile = open("C:\\Users\\Praktyki\\Desktop\\surnames.txt", "r")
    output = open("C:\Users\Praktyki\Desktop\DIS_SEC\output.txt", "w")
    listOfSurnames = [surname.rstrip('\n') for surname in surnamesFile.readlines() ]
    listOfNames = [ name.rstrip('\n') for name in namesFile.readlines()]
    for i in range(1, n+1):
     # generatedLine = str(i) + ";" + random.choice(listOfNames) + ";" + random.choice(listOfSurnames) + ";" + str(random.randrange(20,90))+'\n'
     #output.write(generatedLine)
     cursor.execute("INSERT INTO artists(artist_name, artist_surname, artist_age) VALUES(%s, %s, %s)", (unicode(random.choice(listOfNames), "utf-8"),
                                                                                                        unicode(random.choice(listOfSurnames), "utf-8"),unicode(str(random.randrange(20,80)), "utf-8")))

    surnamesFile.close()
    namesFile.close()



generateArtists(100)