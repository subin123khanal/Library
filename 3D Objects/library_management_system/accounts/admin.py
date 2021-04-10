from django.contrib import admin
from .models import Category, Photo, Students

# Register your models here.

admin.site.register(Students)
admin.site.register(Category)
admin.site.register(Photo)
