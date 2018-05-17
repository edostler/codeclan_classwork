from django.shortcuts import render
# from django.http import HttpResponse
from inventory.models import *

def index(request):
    # return HttpResponse("Hello world!")
    all_artists = Artist.objects.all()
    context = {
        "all_artists": all_artists
    }
    return render(request, "index.html", context)
