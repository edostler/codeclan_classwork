require("pry")
require_relative("models/album")
require_relative("models/artist")

Album.delete_all()
Artist.delete_all()

artist1 = Artist.new({
  "name" => "Blink-182"
  })
artist1.save()

artist2 = Artist.new({
  "name" => "The Offspring"
  })
artist2.save()

album1 = Album.new({
  "artist_id" => artist1.id,
  "title" => "Take Off Your Pants and Jacket",
  "genre" => "Punk-pop"
  })
album1.save()

album2 = Album.new({
  "artist_id" => artist1.id,
  "title" => "Enema of the State",
  "genre" => "Punk-pop"
  })
album2.save()

album3 = Album.new({
  "artist_id" => artist2.id,
  "title" => "Americana",
  "genre" => "Punk-pop"
  })
album3.save()

artists = Artist.all()
albums = Album.all()

albums_by_artist1 = artist1.albums()
albums_by_artist2 = artist2.albums()

artist_of_album1 = album1.artist()
artist_of_album2 = album2.artist()
artist_of_album3 = album3.artist()

# # TEST UPDATE ALBUM
#   album3.genre = "Angrier Punk-pop"
#   album3.update()
#
# # TEST UPDATE ARTIST
#   artist1.name = "Blink"
#   artist1.update()
#
# # TEST DELETE ALBUM
#   album3.delete()
#
# # TEST DELETE ARTIST
#   artist1.delete()
#
# # TEST FIND ALBUM BY ID
#   album_id_to_find = album2.id
#   album = Album.find(album_id_to_find)
#
# # TEST FIND ARTIST BY ID
#   artist_id_to_find = artist2.id
#   artist = Artist.find(artist_id_to_find)

binding.pry
nil
