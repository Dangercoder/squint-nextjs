'use client'

import { useState } from 'react'
import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"

export function UsernameForm(props) {
  const [username, setUsername] = useState('OctopusEnthusiast')
  const [newUsername, setNewUsername] = useState('')

  const handleUsernameChange = (e) => {
    e.preventDefault()
    if (newUsername.trim()) {
      setUsername(newUsername.trim())
      setNewUsername('')
    }
  }

  return (
    (
      <Card className="w-full max-w-md bg-blue-800 text-white">
        <CardHeader>
          <CardTitle>Change Username</CardTitle>
        </CardHeader>
        <CardContent>
          <form onSubmit={handleUsernameChange} className="space-y-4">
            <div className="space-y-2">
              <Label htmlFor="new-username" className="text-blue-200">New Username</Label>
              <Input
                id="new-username"
                value={newUsername}
                onChange={(e) => setNewUsername(e.target.value)}
                className="bg-blue-700 border-blue-600 text-white placeholder-blue-300"
                placeholder="Enter new username" />
            </div>
            <Button
              type="submit"
              onClick=
              {async () => {
          const updatedUsername = await props.handleSubmit(newUsername)
          setNewUsername(updatedUsername)
        }}
              
              className="w-full bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded transition-all duration-300 ease-in-out transform hover:scale-105">
              Update Username
            </Button>
          </form>
        </CardContent>
      </Card>
    )
  );
}