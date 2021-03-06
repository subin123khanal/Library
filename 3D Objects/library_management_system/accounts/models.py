from django.db import models

from django.utils import timezone


# User model /Student Details

class Students(models.Model):
    name = models.CharField(max_length=200, null=False, blank=False)
    username = models.CharField(max_length=200, null=False, blank=False)
    email = models.CharField(max_length=200, unique=True)
    phone = models.IntegerField(null=False, blank=False, unique=True)
    date = models.DateTimeField(default=timezone.now)

    def __str__(self):
        return self.name


# Books ADD Database Model

class Category(models.Model):
    name = models.CharField(max_length=100, null=False, blank=False)
    author = models.CharField(max_length=100, null=True, blank=False)
    quantity = models.CharField(max_length=100, null=True, blank=False)

    def __str__(self):
        return self.name


class Photo(models.Model):
    category = models.ForeignKey(
        Category, on_delete=models.CASCADE, null=True, blank=True)
    image = models.ImageField(null=False, blank=True)
    description = models.TextField()

    def __str__(self):
        return self.description
