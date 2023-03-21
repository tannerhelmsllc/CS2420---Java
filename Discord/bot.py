import random

import discord
from discord.ext import commands
import os

intents = discord.Intents.default()
intents.message_content = True
bot = commands.Bot(command_prefix='', intents=intents)



hostname = "google.com"  # example
response = os.system("ping -c 1 " + hostname)


@bot.event
async def on_ready():
    print(f"Ready!\nUsername: {bot.user}")
    if response == 0:
        print(hostname, "is up")
    else:
        print(hostname, "is down!")


@bot.command()
async def ping(ctx):
    await ctx.send('What server would you like to ping?')

    def server(site):
        return site == os.system("ping -c 1 " + hostname)


@bot.command()
async def command(ctx):
    computer = random.randint(1, 10)
    await ctx.send('Guess my number')

    def check(msg):
        return msg.author == ctx.author and msg.channel == ctx.channel and int(msg.content) in [1, 2, 3, 4, 5, 6, 7, 8,
                                                                                                9, 10]

    msg = await bot.wait_for("message", check=check)

    if int(msg.content) == computer:
        await ctx.send("Correct")
    else:
        await ctx.send(f"Nope it was {computer}")


bot.run('MTA4Nzc4NDA1MzE0NDU1OTY0Ng.GoyGHa.Wiahkk8JQZCBvJ5GzyHqBGPtw8JJHKCOro-QIw')
