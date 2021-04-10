from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth.models import User
from django import forms
from .models import *


class CreateUserForm(UserCreationForm):
    class Meta:
        model = User
        fields = ['username', 'email', 'password1', 'password2', 'date_joined']


class BookForm(forms.ModelForm):
    class Meta:
        model = Category
        fields = ['name', 'author', 'quantity']


class Photo(forms.ModelForm):
    class Meta:
        model = Photo
        fields = ['category', 'image', 'description']


class Students(forms.ModelForm):
    class Meta:
        model = Students
        fields = ['name', 'username', 'email', 'phone', 'date']
